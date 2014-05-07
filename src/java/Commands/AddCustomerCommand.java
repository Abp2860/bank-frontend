
package Commands;

import Controller.Factory;
import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.CustomerDetail;
import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import dk.cphbusiness.bank.contract.dto.CustomerSummary;
import dk.cphbusiness.bank.contract.eto.NoSuchCustomerException;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Anders
 */
public class AddCustomerCommand extends TargetCommand
{

    public AddCustomerCommand(String target, List<SecurityRole> roles)
    {
        super(target, roles);
    }

    @Override
    public String execute(HttpServletRequest request)
    {
        BankManager manager = Factory.getInstance().getManager();
        
        try{
            String cpr = request.getParameter("cpr");
            CustomerIdentifier customerid = CustomerIdentifier.fromString(cpr);
            CustomerDetail customer = manager.showCustomer(customerid);
            customer.setTitle(request.getParameter("title"));
            customer.setFirstName(request.getParameter("fName"));
            customer.setLastName(request.getParameter("lName"));
            customer.setStreet(request.getParameter("adress"));
            customer.setPostalCode(request.getParameter("postcode"));
            customer.setPostalDistrict(request.getParameter("city"));
            customer.setPhone(request.getParameter("phone"));
            customer.setEmail(request.getParameter("email"));
            
            Collection<CustomerSummary> customers = manager.listCustomers();
            request.setAttribute("customers", customer);
        
       } catch (NoSuchCustomerException ex)  {
            String title = request.getParameter("title");
            String cpr = request.getParameter("cpr");
            String fName = request.getParameter("fName");
            String lName = request.getParameter("lName");
            String address = request.getParameter("address");
            String postcode = request.getParameter("postcode");
            String city = request.getParameter("city");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            CustomerDetail customer = new CustomerDetail(cpr, title, fName, lName, address, postcode, city, phone, email);
            manager.saveCustomer(customer);
            
            Collection<CustomerSummary> customers = manager.listCustomers();
            request.setAttribute("customers", customer);   
        }      
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
    
}


package Commands;

import Controller.Factory;
import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.CustomerDetail;
import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import dk.cphbusiness.bank.contract.eto.NoSuchCustomerException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Anders
 */
public class EditCustomerCommand extends TargetCommand
{

    public EditCustomerCommand(String target, List<SecurityRole> roles)
    {
        super(target, roles);
    }

    @Override
    public String execute(HttpServletRequest request)
    {
    BankManager manager = Factory.getInstance().getManager();
    CustomerIdentifier cpr = CustomerIdentifier.fromString(request.getParameter("cpr"));
    
    try {
        CustomerDetail customer = manager.showCustomer(cpr);
        request.setAttribute("customer", customer);
        
    } catch (NoSuchCustomerException ex){
        Logger.getLogger(EditCustomerCommand.class.getName()).log(Level.SEVERE, null, ex);
        
    }
    
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }

}

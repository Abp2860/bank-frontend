
package Commands;

import Controller.Factory;
import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.AccountDetail;
import dk.cphbusiness.bank.contract.dto.AccountSummary;
import dk.cphbusiness.bank.contract.dto.CheckingAccountDetail;
import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import dk.cphbusiness.bank.contract.eto.CustomerBannedException;
import dk.cphbusiness.bank.contract.eto.NoSuchCustomerException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Anders
 */
public class AddAccountCommand extends TargetCommand
{

    public AddAccountCommand(String target, List<SecurityRole> roles)
    {
        super(target, roles);
    }

    @Override
    public String execute(HttpServletRequest request)
    {
        BankManager manager = Factory.getInstance().getManager();
        CustomerIdentifier customer = CustomerIdentifier.fromString(request.getParameter("cpr"));
        
        BigDecimal interest = new BigDecimal(request.getParameter("interest"));
        
        AccountDetail account = new CheckingAccountDetail(interest);
        
        try{
            manager.createAccount(customer, account);
            } catch (NoSuchCustomerException ex) {
	    Logger.getLogger(AddAccountCommand.class.getName()).log(Level.SEVERE, null, ex);
	} catch (CustomerBannedException ex) {
	    Logger.getLogger(AddAccountCommand.class.getName()).log(Level.SEVERE, null, ex);
	}
        Collection<AccountSummary> accounts = manager.listCustomerAccounts(customer);
        
        request.setAttribute("customer", customer);
        request.setAttribute("accounts", accounts);
        
        
        
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
    
}

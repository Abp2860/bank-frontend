
package Commands;

import Controller.Factory;
import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.AccountSummary;
import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Anders
 */
public class EditTransferCommand extends TargetCommand
{

    public EditTransferCommand(String target, List<SecurityRole> roles)
    {
        super(target, roles);
    }

    @Override
    public String execute(HttpServletRequest request)
    {
        BankManager manager = Factory.getInstance().getManager();
        CustomerIdentifier customer = CustomerIdentifier.fromString(request.getParameter("cpr"));
        Collection<AccountSummary> accounts = manager.listCustomerAccounts(customer);
        
        request.setAttribute("accounts", accounts);
        request.setAttribute("customer", customer);
        
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
    
}

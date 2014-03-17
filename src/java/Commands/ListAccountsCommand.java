
package Commands;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.AccountIdentifier;
import dk.cphbusiness.bank.contract.dto.AccountSummary;
import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import Controller.Factory;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Anders
 */
public class ListAccountsCommand extends TargetCommand
{

    public ListAccountsCommand(String target, List<SecurityRole> roles)
    {
        super(target, roles);
    }

    @Override
    public String execute(HttpServletRequest request){
    String number = request.getParameter("customerID");
    AccountIdentifier.fromString(number);
        
           
        CustomerIdentifier customer = CustomerIdentifier.fromString(number);
        Collection<AccountSummary> accounts = Factory.getInstance().getManager().listCustomerAccounts(customer);

    request.setAttribute("accounts", accounts);
   
    return super.execute(request); 
    }
    
    }


package Commands;


import Commands.TargetCommand;
import dk.cphbusiness.bank.contract.dto.AccountIdentifier;
import dk.cphbusiness.bank.contract.dto.TransferSummary;
import Controller.Factory;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;


/**
 *
 * @author Anders
 */
public class ListAccountDetailCommand extends TargetCommand
{

    public ListAccountDetailCommand(String target, List<SecurityRole> roles)
    {
        super(target, roles);
    }

    @Override
    public String execute(HttpServletRequest request)
    {
        String number = request.getParameter("number");
        AccountIdentifier ai = AccountIdentifier.fromString(number);
        Collection<TransferSummary> history;
        history = Factory.getInstance().getManager().showAccountHistory(ai).getTransfers();
        
        request.setAttribute("history", history);
        request.setAttribute("number", number);
        return super.execute(request);
    }
    
}

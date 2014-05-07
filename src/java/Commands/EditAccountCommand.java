
package Commands;

import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Anders
 */
public class EditAccountCommand extends TargetCommand
{

    public EditAccountCommand(String target, List<SecurityRole> roles)
    {
        super(target, roles);
    }

    @Override
    public String execute(HttpServletRequest request)
    {
        CustomerIdentifier customer = CustomerIdentifier.fromString(request.getParameter("cpr"));
        request.setAttribute("customer", customer);
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
    
}

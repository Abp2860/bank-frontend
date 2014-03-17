
package dk.cphbusiness.bank.view;

import Commands.TargetCommand;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Anders
 */
public class PrepareTransfer extends TargetCommand
{

    public PrepareTransfer(String target, List<SecurityRole> roles)
    {
        super(target, roles);
    }

    @Override
    public String execute(HttpServletRequest request)
    {
        String number = request.getParameter("number");
        
        request.setAttribute("number", number);
        return super.execute(request); 
    }
    
}

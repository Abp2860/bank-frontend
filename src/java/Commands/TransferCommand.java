
package Commands;

import dk.cphbusiness.bank.contract.dto.AccountIdentifier;
import dk.cphbusiness.bank.contract.eto.InsufficientFundsException;
import dk.cphbusiness.bank.contract.eto.NoSuchAccountException;
import dk.cphbusiness.bank.contract.eto.TransferNotAcceptedException;
import Controller.Factory;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Anders
 */
public class TransferCommand extends TargetCommand
{

    public TransferCommand(String target, List<SecurityRole> roles) {
        
        super(target, roles);
        
    }
   
    @Override
    public String execute(HttpServletRequest request) {
       String targetR = request.getParameter("target");
       String sourceR = request.getParameter("source");
       String amount = request.getParameter("amount");
        BigDecimal tamount = new BigDecimal(amount.replaceAll(",", ""));
        AccountIdentifier source = AccountIdentifier.fromString(sourceR);
        AccountIdentifier target = AccountIdentifier.fromString(targetR);
        System.out.println("hhhhh" + source + target + tamount);
        try {
            Factory.getInstance().getManager().transferAmount(tamount, source, target);
        } catch (NoSuchAccountException ex) {
            Logger.getLogger(TransferCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransferNotAcceptedException ex) {
            Logger.getLogger(TransferCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InsufficientFundsException ex) {
            Logger.getLogger(TransferCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

        return super.execute(request);
    }
}

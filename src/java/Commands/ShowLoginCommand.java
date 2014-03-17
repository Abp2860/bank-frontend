
package Commands;

import java.util.List;
import security.SecurityRole;

/**
 *
 * @author Anders
 */
public class ShowLoginCommand extends TargetCommand
{

    public ShowLoginCommand(String target,List<SecurityRole> roles){
        
     super(target, roles);
  }
}

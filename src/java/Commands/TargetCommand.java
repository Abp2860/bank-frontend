
package Commands;

import Commands.Command;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Anders
 */
public class TargetCommand implements Command {
  private String target;
  List<SecurityRole> roles;
    
  public TargetCommand(String target, List<SecurityRole> roles) {
    this.target = target;
    this.roles = roles;
    }
  
 public List<SecurityRole> getRoles()
    {
        return roles;
    }
  
  @Override
  public String execute(HttpServletRequest request) {
    return target;
    }
  
  }

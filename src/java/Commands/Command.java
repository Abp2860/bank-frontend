
package Commands;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Anders
 */
public interface Command
{
String execute(HttpServletRequest request);
}


package dk.cphbusiness.bank.view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anders
 */
@WebServlet(name = "Back", urlPatterns ={   "/Back"})
public class Back extends HttpServlet
{

    @Override
    protected void service(HttpServletRequest req, 
            HttpServletResponse resp) 
            throws ServletException, IOException
    {
      req.setAttribute("message", "You just inspected the accounts");
    
    RequestDispatcher dispatcher = req.getRequestDispatcher("main.jsp");
    dispatcher.forward(req, resp);
    
    }

  
  
}




package Controller;

import Commands.TargetCommand;
import Commands.Command;
import Commands.ListAccountsCommand;
import Commands.ListCustomersCommand;
import Commands.LogoutCommand;
import Commands.ShowLoginCommand;
import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.AccountSummary;
import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
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
@WebServlet(name = "FrontController", urlPatterns ={"/Controller"})
public class FrontController extends HttpServlet{

  private int PORT_NON_SSL;
  private int PORT_SSL;

 public FrontController() {
    
    }

    
    protected void processRequest(HttpServletRequest req, 
    HttpServletResponse resp) 
    throws ServletException, IOException{
        
    String key = req.getParameter("command");
    
    
    Command command = Factory.getInstance().getCommand(key, req);
    String target = command.execute(req);
    RequestDispatcher dispatcher = req.getRequestDispatcher(target);
    dispatcher.forward(req, resp);
    String path = command.execute(req);
   
   
 if (command instanceof ShowLoginCommand && !req.isSecure()) {
      String SSL = "https://" + req.getServerName() + ":" + PORT_SSL + req.getRequestURI() + "?command=showlogin";
      System.out.println("SSL redirect: " + SSL);
      resp.sendRedirect(SSL);
    } else if (command instanceof LogoutCommand) {
      String nonSSL = "http://" + req.getServerName() + ":" + PORT_NON_SSL + req.getRequestURI();
      System.out.println("Non SSL redirect: " + nonSSL);
      resp.sendRedirect(nonSSL);
    } 
    else {
      req.getRequestDispatcher(path).forward(req, resp);
    }
    

  }

  @Override
  public void init() throws ServletException {
    PORT_NON_SSL = Integer.parseInt(getServletContext().getInitParameter("portNonSSL"));
    PORT_SSL = Integer.parseInt(getServletContext().getInitParameter("portSSL"));
  }
    
@Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

 
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }
  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>
}

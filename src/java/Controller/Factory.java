package Controller;

import Commands.ListAccountDetailCommand;
import Commands.Command;
import Commands.ListAccountsCommand;
import Commands.ListCustomersCommand;
import Commands.LoginCommand;
import Commands.LogoutCommand;
import Commands.ShowLoginCommand;
import Commands.TargetCommand;
import Commands.TransferCommand;
import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.control.BankManagerBean;
import dk.cphbusiness.bank.view.PrepareTransfer;
//import dk.cphbusiness.dummy.bank.control.DummyBankManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Anders
 */
public class Factory {

    BankManagerBean bankManagerBean = lookupBankManagerBeanBean();

    private static Factory instance = null;
    private final BankManagerBean manager;
    private final Map<String, Command> commands = new HashMap<>();

    private Factory() {

        manager = lookupBankManagerBeanBean();

        Map<SecurityRole, String> roles = new HashMap();
        roles.put(SecurityRole.Employee, "/employees/startEmployeePage.jsp");
        roles.put(SecurityRole.SuperEmployee, "/superEmployee/addCustomer.jsp");
        roles.put(SecurityRole.Customer, "/customers/startCustomerPage.jsp");

        commands.put("back", new TargetCommand("all/main.jsp", Arrays.asList(SecurityRole.All)));
        commands.put("main", new TargetCommand("all/main.jsp", Arrays.asList(SecurityRole.All)));

        commands.put("showlogin", new ShowLoginCommand("/login/login.jsp", Arrays.asList(SecurityRole.All)));
        commands.put("login", new LoginCommand(roles, "/login/login.jsp"));
        commands.put("logout", new LogoutCommand("/all/main.jsp", Arrays.asList(SecurityRole.All)));

        commands.put("employee-main", new TargetCommand("employees/startEmployeePage.jsp", Arrays.asList(SecurityRole.Employee, SecurityRole.SuperEmployee)));

        commands.put("list-customers", new ListCustomersCommand("employees/customer-list.jsp", Arrays.asList(SecurityRole.Employee, SecurityRole.SuperEmployee)));
        commands.put("list-customer-accounts", new ListAccountsCommand("employees/account-list.jsp", Arrays.asList(SecurityRole.Employee, SecurityRole.SuperEmployee)));
        commands.put("show-account-detail", new ListAccountDetailCommand("employees/account-detail.jsp", Arrays.asList(SecurityRole.Employee, SecurityRole.SuperEmployee)));

        commands.put("prepare-transfer", new PrepareTransfer("employess/transfer-edit.jsp", Arrays.asList(SecurityRole.Employee, SecurityRole.SuperEmployee)));
        commands.put("transfer-command", new TransferCommand("employess/transfer-edit.jsp", Arrays.asList(SecurityRole.Employee, SecurityRole.SuperEmployee)));
    }

    public static Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public BankManager getManager() {
        return manager;
    }

    public Command getCommand(String key, HttpServletRequest request) {
        if (key == null) {
            key = "main";
        }
        Command cmd = commands.get(key);
        SecurityCheck(cmd, request); //Add this line between these two lines
        return cmd;
    }

    private void SecurityCheck(Command command, HttpServletRequest request) throws SecurityException {
        if (command instanceof TargetCommand) {
            List<SecurityRole> requiredRoles = ((TargetCommand) command).getRoles();
            boolean requiredRoleFound = false;
            for (SecurityRole requiredRole : requiredRoles) {
                if (requiredRole == SecurityRole.All || request.isUserInRole(requiredRole.toString())) {
                    requiredRoleFound = true;
                    break;
                }
            }
            if (!requiredRoleFound) {
                throw new SecurityException("You don't have the necessary rights to perform this command");
            }
        }
    }

    private BankManagerBean lookupBankManagerBeanBean() {
        try {
            Context c = new InitialContext();
            return (BankManagerBean) c.lookup("java:global/AbpFrontEnd/BankManagerBean!dk.cphbusiness.bank.control.BankManagerBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}

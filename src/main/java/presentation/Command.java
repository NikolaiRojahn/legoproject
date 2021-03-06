package presentation;

/**
 *
 * @author nr
 */
import function.LoginSampleException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        commands.put( "backdoor", new LoginBackdoor() );
        commands.put( "placeOrder", new PlaceOrder() );
        commands.put( "index", new Index() );
        commands.put( "showOrders", new ShowOrders() );
        commands.put( "showOrderDetails", new ShowOrderDetails() );
        commands.put( "backToShop", new BackToShop() );
        commands.put( "backToOrders", new BackToOrders() );
    }

    static Command from( HttpServletRequest request ) {
        String commandName = request.getParameter( "command" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand() );
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws LoginSampleException;

}
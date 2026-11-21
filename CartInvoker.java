/**
 * Class file that allows command, when called to execute within the context of adding items to grocery cart list.
 *
 * @author Josh Findley
 * @version 11/14/2026
 */
// Invoker implementation for command design pattern.
public class CartInvoker {
    public void executeCommand(Command command) {
        command.execute();
    }
}
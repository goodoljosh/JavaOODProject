// Invoker in the COMMAND PATTERN. It triggers the requested checkout command.
public class CheckoutInvoker {
    public Order submitCheckout(Command<Order> command) {
        return command.execute();
    }
}

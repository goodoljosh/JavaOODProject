import java.math.BigDecimal;

public class FreshCartDemo {
    public static void main(String[] args) {
        // FACTORY: create a customer account.
        Customer customer = (Customer) UserFactory.createUser(
                "CUSTOMER", "Alea Turner", "alea@example.com");

        // Set up products and the shopping cart.
        Product apples = new Product("P100", "Apples", new BigDecimal("3.99"));
        Product bread = new Product("P200", "Bread", new BigDecimal("2.49"));

        ShoppingCart cart = new ShoppingCart();

        // OBSERVER: subscribe the customer to cart notifications.
        cart.addObserver(new CartNotification(customer.getName()));

        cart.addItem(apples, 2);
        cart.addItem(bread, 1);
        cart.updateQuantity("P200", 2);

        // Prepare inventory.
        InventoryService inventory = new InventoryService();
        inventory.setStock("P100", 10);
        inventory.setStock("P200", 8);

        // STRATEGY: choose one payment method.
        PaymentService payments = new PaymentService();
        payments.setPaymentStrategy(new CardPayment("1234"));
        // Alternative: payments.setPaymentStrategy(new CashOnPickupPayment());

        // Prepare order service and checkout command.
        OrderService orders = new OrderService();
        CheckoutCommand checkout = new CheckoutCommand(
                customer, cart, inventory, payments, orders);

        // COMMAND: invoker executes the checkout request.
        CheckoutInvoker invoker = new CheckoutInvoker();

        try {
            Order completedOrder = invoker.submitCheckout(checkout);

            // Display order confirmation after successful checkout.
            new OrderConfirmation().display(completedOrder);
        } catch (RuntimeException exception) {
            System.out.println("Checkout could not be completed: " + exception.getMessage());
        }
    }
}

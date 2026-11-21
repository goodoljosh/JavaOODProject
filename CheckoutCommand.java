import java.math.BigDecimal;
import java.util.List;

// COMMAND PATTERN: encapsulates the checkout and order-processing request.
public class CheckoutCommand implements Command<Order> {
    private final Customer customer;
    private final ShoppingCart cart;
    private final InventoryService inventory;
    private final PaymentService payments;
    private final OrderService orders;

    public CheckoutCommand(Customer customer, ShoppingCart cart,
                           InventoryService inventory, PaymentService payments,
                           OrderService orders) {
        this.customer = customer;
        this.cart = cart;
        this.inventory = inventory;
        this.payments = payments;
        this.orders = orders;
    }

    @Override
    public Order execute() {
        if (cart.isEmpty()) throw new IllegalStateException("Your cart is empty.");

        List<CartItem> itemsBeingPurchased = cart.getItems();
        BigDecimal total = cart.getTotal();

        // Verify stock before charging the customer.
        if (!inventory.hasStock(itemsBeingPurchased)) {
            throw new IllegalStateException("An item is unavailable or out of stock.");
        }

        PaymentResult payment = payments.processPayment(total);
        if (!payment.isSuccessful()) {
            throw new IllegalStateException("Payment was declined: " + payment.getMessage());
        }

        // Save order and deduct stock after payment succeeds.
        Order order = orders.createOrder(customer, cart, payment);
        inventory.deductStock(itemsBeingPurchased);
        cart.clear();
        return order;
    }
}

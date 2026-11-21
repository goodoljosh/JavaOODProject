import java.math.BigDecimal;

// Concrete observer that sends a customer-facing cart notification.
public class CartNotification implements CartObserver {
    private final String customerName;

    public CartNotification(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public void onCartUpdated(String message, BigDecimal cartTotal) {
        System.out.println("Cart notification for " + customerName + ": "
                + message + " Current total: $" + cartTotal);
    }
}

import java.math.BigDecimal;

// OBSERVER PATTERN: defines the notification received when a cart changes.
public interface CartObserver {
    void onCartUpdated(String message, BigDecimal cartTotal);
}

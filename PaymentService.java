import java.math.BigDecimal;

// Uses the STRATEGY PATTERN without changing the checkout workflow.
public class PaymentService {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        if (strategy == null) throw new IllegalArgumentException("Select a payment method.");
        this.strategy = strategy;
    }

    public PaymentResult processPayment(BigDecimal amount) {
        if (strategy == null) throw new IllegalStateException("No payment method selected.");
        if (amount == null || amount.signum() <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than zero.");
        }
        return strategy.pay(amount);
    }
}

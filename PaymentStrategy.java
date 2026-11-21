import java.math.BigDecimal;

// STRATEGY PATTERN: common interface for interchangeable payment methods.
public interface PaymentStrategy {
    PaymentResult pay(BigDecimal amount);
}

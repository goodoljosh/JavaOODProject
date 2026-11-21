import java.math.BigDecimal;
import java.util.UUID;

public class CashOnPickupPayment implements PaymentStrategy {
    @Override
    public PaymentResult pay(BigDecimal amount) {
        String reference = "PICKUP-" + UUID.randomUUID().toString().substring(0, 8);
        return new PaymentResult(true,
                "Cash on pickup selected; payment is due at pickup.", reference);
    }
}

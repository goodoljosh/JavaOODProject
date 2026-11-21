import java.math.BigDecimal;
import java.util.UUID;

public class CardPayment implements PaymentStrategy {
    private final String lastFourDigits;

    public CardPayment(String lastFourDigits) {
        this.lastFourDigits = lastFourDigits;
    }

    @Override
    public PaymentResult pay(BigDecimal amount) {
        // Demonstration stub only. A real application must use a secure payment provider.
        String reference = "CARD-" + UUID.randomUUID().toString().substring(0, 8);
        return new PaymentResult(true,
                "Card payment approved (ending " + lastFourDigits + ").", reference);
    }
}

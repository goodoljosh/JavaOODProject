public class PaymentResult {
    private final boolean successful;
    private final String message;
    private final String reference;

    public PaymentResult(boolean successful, String message, String reference) {
        this.successful = successful;
        this.message = message;
        this.reference = reference;
    }

    public boolean isSuccessful() { return successful; }
    public String getMessage() { return message; }
    public String getReference() { return reference; }
}

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Order {
    private final String orderNumber;
    private final String customerId;
    private final List<CartItem> items;
    private final BigDecimal total;
    private final String paymentStatus;
    private final String paymentReference;

    public Order(String customerId, List<CartItem> cartItems, BigDecimal total,
                 String paymentStatus, String paymentReference) {
        this.orderNumber = "FC-" + UUID.randomUUID().toString()
                .substring(0, 8).toUpperCase();
        this.customerId = customerId;
        this.items = new ArrayList<>();
        for (CartItem item : cartItems) {
            this.items.add(new CartItem(item.getProduct(), item.getQuantity()));
        }
        this.total = total;
        this.paymentStatus = paymentStatus;
        this.paymentReference = paymentReference;
    }

    public String getOrderNumber() { return orderNumber; }
    public String getCustomerId() { return customerId; }
    public List<CartItem> getItems() { return Collections.unmodifiableList(items); }
    public BigDecimal getTotal() { return total; }
    public String getPaymentStatus() { return paymentStatus; }
    public String getPaymentReference() { return paymentReference; }
}

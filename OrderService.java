import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Creates and retains completed orders. Replace this in-memory list with JDBC/DAO
// persistence when connecting FreshCart to the project MySQL database.
public class OrderService {
    private final List<Order> orders = new ArrayList<>();

    public Order createOrder(Customer customer, ShoppingCart cart, PaymentResult payment) {
        Order order = new Order(customer.getUserId(), cart.getItems(), cart.getTotal(),
                payment.getMessage(), payment.getReference());
        orders.add(order);
        return order;
    }

    public List<Order> getOrders() {
        return Collections.unmodifiableList(orders);
    }
}

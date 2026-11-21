import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryService {
    private final Map<String, Integer> stock = new HashMap<>();

    public void setStock(String productId, int quantity) {
        if (quantity < 0) throw new IllegalArgumentException("Stock cannot be negative.");
        stock.put(productId, quantity);
    }

    public boolean hasStock(List<CartItem> items) {
        for (CartItem item : items) {
            int available = stock.getOrDefault(item.getProduct().getProductId(), 0);
            if (item.getQuantity() > available) return false;
        }
        return true;
    }

    public void deductStock(List<CartItem> items) {
        if (!hasStock(items)) throw new IllegalStateException("Insufficient inventory.");
        for (CartItem item : items) {
            String id = item.getProduct().getProductId();
            stock.put(id, stock.get(id) - item.getQuantity());
        }
    }
}

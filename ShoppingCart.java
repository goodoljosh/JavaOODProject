import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// Cart subject in the OBSERVER PATTERN.
public class ShoppingCart {
    private final Map<String, CartItem> items = new LinkedHashMap<>();
    private final List<CartObserver> observers = new ArrayList<>();

    public void addObserver(CartObserver observer) {
        if (observer != null) observers.add(observer);
    }

    public void removeObserver(CartObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(String message) {
        BigDecimal total = getTotal();
        for (CartObserver observer : observers) {
            observer.onCartUpdated(message, total);
        }
    }

    public void addItem(Product product, int quantity) {
        if (product == null || quantity <= 0) {
            throw new IllegalArgumentException("Product and positive quantity are required.");
        }

        String id = product.getProductId();
        CartItem existing = items.get(id);
        if (existing == null) {
            items.put(id, new CartItem(product, quantity));
        } else {
            existing.setQuantity(existing.getQuantity() + quantity);
        }
        notifyObservers(quantity + " " + product.getName() + "(s) added.");
    }

    public void updateQuantity(String productId, int quantity) {
        CartItem item = items.get(productId);
        if (item == null) throw new IllegalArgumentException("Item is not in the cart.");

        if (quantity <= 0) {
            removeItem(productId);
            return;
        }

        item.setQuantity(quantity);
        notifyObservers("Quantity updated for " + item.getProduct().getName() + ".");
    }

    public void removeItem(String productId) {
        CartItem removed = items.remove(productId);
        if (removed != null) {
            notifyObservers(removed.getProduct().getName() + " removed from cart.");
        }
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (CartItem item : items.values()) {
            total = total.add(item.getSubtotal());
        }
        return total;
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(new ArrayList<>(items.values()));
    }

    public boolean isEmpty() { return items.isEmpty(); }

    public void clear() {
        items.clear();
        notifyObservers("Cart cleared after checkout.");
    }
}

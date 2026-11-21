/**
 * Uses hashmap to add items, remove items, update quantity, etc.
 *
 * @author Josh Findley
 * @version 11/14/2026
 */
import java.util.HashMap;
import java.util.Map;
// Receiver: Shopping Cart
public class ShoppingCart {
    //Create a hashmap to store Item information and quantity
    private Map<Product, Integer> items = new HashMap<>();

    public void addItem(Product product, int quantity) {
        items.put(product, items.getOrDefault(product, 0) + quantity);
        System.out.println("[Cart] Added " + quantity + "x " + product.getName());
    }

    public void removeItem(Product product) {
        items.remove(product);
        System.out.println("[Cart] Removed " + product.getName() + " completely.");
    }

    public void updateQuantity(Product product, int newQuantity) {
        if (newQuantity <= 0) {
            removeItem(product);
        } else {
            items.put(product, newQuantity);
            System.out.println("Shopping cart has been updated " + product.getName() + " quantity to " + newQuantity);
        }
    }
    //Checks if cart is empty
    public void displayCart() {
        System.out.println("Displaying current shopping cart");
        if (items.isEmpty()) {
            System.out.println("Shopping cart is currently empty.");
            return;
        }
        double total = 0;
        for (Product p : items.keySet()) {
            int qty = items.get(p);
            double subtotal = p.getPrice() * qty;
            total += subtotal;
            System.out.println(p.getName() + " x " + qty + " = $" + subtotal);
        }
        System.out.println("Total Cart Value: $" + total);
    }
}
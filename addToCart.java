/**
 * Creates methods to add inttial values to the shopping cart list.
 *
 * @author Josh Findley
 * @version 11/14/2026
 */
// Concrete Command: Add to Cart
public class addToCart implements Command {
    private ShoppingCart cart;
    private Product product;
    private int quantity;

    public addToCart(ShoppingCart cart, Product product, int quantity) {
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
    }
    
    @Override
    public void execute() {
        cart.addItem(product, quantity);
    }

    @Override
    public void undo() {
        cart.removeItem(product);
    }
}
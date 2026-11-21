/**
 * Clas that holds variables and methods to update shopping cart quantity without 
 *
 * @author Josh Findley
 * @version 11/14/2026
 */
// Concrete Command interface used here to update quantity.
public class UpdateQuantityCommand implements Command {
    private ShoppingCart cart;
    private Product product;
    private int newQuantity;
    private int oldQuantity;
    //Update quantity command constructor
    public UpdateQuantityCommand(ShoppingCart cart, Product product, int newQuantity, int oldQuantity) {
        this.cart = cart;
        this.product = product;
        this.newQuantity = newQuantity;
        this.oldQuantity = oldQuantity;
    }
    //Overrides base execute method with new quantity value.
    @Override
    public void execute() {
        cart.updateQuantity(product, newQuantity);
    }
    //Undoes last action to quantity with previously stored oldQuantity variable.
    @Override
    public void undo() {
        cart.updateQuantity(product, oldQuantity);
    }
}
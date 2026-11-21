/**
 * Inventory object associated with Product.
 */
public class Inventory {

    private Product product;
    private int quantity;

    public Inventory(Product product,
                     int quantity) {

        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {

        return product;
    }

    public int getQuantity() {

        return quantity;
    }

    public void addStock(int amount) {

        quantity += amount;
    }

    public void removeStock(int amount) {

        if(quantity >= amount) {

            quantity -= amount;
        }
    }

    public boolean inStock(int amount) {

        return quantity >= amount;
    }
}
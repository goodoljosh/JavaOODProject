/**
 * Main class/method file responsible for formatting and populating pre-exsisting functions.
 *
 * @author Josh Findley
 * @version 11/14/2026
 */
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Product Catalog
        productCatalog catalog = new productCatalog();
        //Adding product with features such as, product number, name, product type, cost, and the products rating for the shopping service.
        catalog.addProduct(new Product("P1", "Laptop", "Electronics", 1200.00, 4.5));
        catalog.addProduct(new Product("P2", "Wireless Mouse", "Electronics", 25.50, 4.2));
        catalog.addProduct(new Product("P3", "Coffee Maker", "Home", 80.00, 4.0));
        catalog.addProduct(new Product("P4", "Running Shoes", "Sports", 95.00, 4.8));
        
        catalog.displayCatalog();
        System.out.println();

        //Product Search
        System.out.println("Testing Filter Strategy (Product Catagory-Electronics)");
        //Given an argument, categoryFilter using strategy pattern implementation is creating a new category filter object that will then send the data
        SearchFilter electronicsFilter = new categoryFilter("Electronics");
        List<Product> electronics = catalog.searchAndFilter(electronicsFilter);
        
        for (Product p : electronics) {
            System.out.println("Found: " + p.getName());
        }
        System.out.println();
        //Add items to p when affordable items using searchAndFiter is less than or equal to 100
        System.out.println("Filter will be less than or eqaul to $100 ");
        SearchFilter priceFilter = new maxPriceFilter(100.00);
        List<Product> affordableItems = catalog.searchAndFilter(priceFilter);
        for (Product p : affordableItems) {
            System.out.println("Found: " + p);
        }
        System.out.println();

        // Command design pattern creating new ShoppingCart and CartInvoker objects respectfully.
        ShoppingCart cart = new ShoppingCart();
        CartInvoker invoker = new CartInvoker();

        // Add items using command design pattern
        Command addMouse = new addToCart(cart, electronics.get(1), 2);
        Command addCoffee = new addToCart(cart, affordableItems.get(1), 1);
        //
        invoker.executeCommand(addMouse);
        invoker.executeCommand(addCoffee);
        System.out.println();

        cart.displayCart();
        System.out.println();

        // Update quantity through command design pattern
        System.out.println("Updated cart quantities");
        Command updateMouseQty = new UpdateQuantityCommand(cart, electronics.get(1), 5, 2);
        invoker.executeCommand(updateMouseQty);
        System.out.println();
        
        //Displays cart contents
        
        cart.displayCart();
    }
}
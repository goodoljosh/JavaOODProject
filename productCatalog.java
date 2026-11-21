/**
 * Class that manages product names in a virtual catalog
 *
 * @author Josh Findley
 * @version 11/14/2026
 */
// Product Catalog Management Class
import java.util.ArrayList;
import java.util.List;

public class productCatalog {
    //creates an ArrayList
    private List<Product> catalog = new ArrayList<>();

    public void addProduct(Product product) {
        catalog.add(product);
    }
    //Displays each item in catalog
    public void displayCatalog() {
        System.out.println("Full Product Catalog");
        for (Product p : catalog) {
            System.out.println(p);
        }
    }
    
    // Uses the strategy pattern to filter products
    public List<Product> searchAndFilter(SearchFilter strategy) {
        return strategy.filter(catalog);
    }
}
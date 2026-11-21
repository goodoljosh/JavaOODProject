
/**
 * Class file that holds objects for necessary product information.
 *
 * @author Josh Findley
 * @version 11/14/2026
 */
public class Product {
    private String id;
    private String name;
    private String category;
    private double price;
    private double rating;

    //Constructor used to initialize product details/content
    public Product(String id, String name, String category, double price, double rating) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.rating = rating;
    }
    //Getters for each
    public String getId() { 
        return id;
    }
    
    public String getName() { 
        return name; 
    }
    
    public String getCategory() { 
        return category; 
    }
    
    public double getPrice() {
        return price;
    }
    
    public double getRating() { 
        return rating;
    }
    //toString method being overridden to customize formatting of data
    @Override
    public String toString() {
        return name + " (" + category + ") - $" + price;
    }
}
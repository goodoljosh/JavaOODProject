/**
 * Class file that implements a product list sorting algorithm
 *
 * @author Josh Findley
 * @version 11/14/2026
 */
import java.util.List;
import java.util.ArrayList;
public class categoryFilter implements SearchFilter {
    private String targetCategory;  

    public categoryFilter(String targetCategory) {
        this.targetCategory = targetCategory;
    }
   //Using list product, filter through items that matches them based on the targetCategory and adds them to a filtered list(ignores Upper case restrictions)
   @Override
    public List<Product> filter(List<Product> products) {
        List<Product> filteredList = new ArrayList<>();
        
        // Loop through products and add matches to the new list
        for (Product p : products) {
            if (p.getCategory().equalsIgnoreCase(targetCategory)) {
                filteredList.add(p);
            }
        }
        
        return filteredList;
    }
}
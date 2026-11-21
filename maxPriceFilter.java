/**
 * Class file that filters the project list based on a given maximum price.
 *
 * @author Josh Findley
 * @version 11/14/2026
 */

import java.util.List;
import java.util.ArrayList;

// Concrete Strategy implementation that filters by maximum price
public class maxPriceFilter implements SearchFilter {
    private double maxPrice;

    public maxPriceFilter(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Override
    public List<Product> filter(List<Product> products) {
        List<Product> filteredList = new ArrayList<>();

        // Given for loop moves through product list and stores items that are equal to or below given max price.
        for (Product p : products) {
            if (p.getPrice() <= maxPrice) {
                filteredList.add(p);
            }
        }

        return filteredList;
    }
}
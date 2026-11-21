/**
 * Interface implementation that allows filter behaviors to be added without altering exsisting product code.
 *
 * @author Josh Findley
 * @version 11/14/2026
 */

import java.util.List;
import java.util.stream.Collectors;
// Strategy interface implementation
public interface SearchFilter {
    List<Product> filter(List<Product> products);
}
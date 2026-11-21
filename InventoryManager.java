import java.util.HashMap;
import java.util.Map;

public class InventoryManager {

    private Map<String, Inventory> inventoryMap =
            new HashMap<>();

    public void addInventory(
            Inventory inventory) {

        inventoryMap.put(
                inventory.getProduct().getId(),
                inventory);
    }

    public Inventory findInventory(
            String productId) {

        return inventoryMap.get(productId);
    }

    public void displayInventory() {

        System.out.println(
                "\nCurrent Inventory");

        for(Inventory inventory :
                inventoryMap.values()) {

            System.out.println(
                    inventory.getProduct().getName()
                    + " : "
                    + inventory.getQuantity());
        }
    }
}
/**
 * Customer User
 */
public class Customer extends User
                      implements Observer {

    public Customer(String userId,
                    String username,
                    String password) {

        super(userId, username, password);
    }

    @Override
    public void displayRole() {

        System.out.println("Customer Account");
    }

    @Override
    public void update(String message) {

        System.out.println(
                "[Customer Notification] "
                + message);
    }
}
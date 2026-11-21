/**
 * Administrator User
 */
public class Admin extends User {

    public Admin(String userId,
                 String username,
                 String password) {

        super(userId, username, password);
    }

    @Override
    public void displayRole() {

        System.out.println("Administrator Account");
    }
}
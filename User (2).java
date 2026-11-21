/**
 * Abstract superclass for all users.
 *
 * @author Nicholas Burr
 */
public abstract class User {

    protected String userId;
    protected String username;
    protected String password;

    public User(String userId,
                String username,
                String password) {

        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public abstract void displayRole();
}
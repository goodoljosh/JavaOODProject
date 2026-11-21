import java.util.HashMap;
import java.util.Map;

public class LoginManager {

    private Map<String, User> users =
            new HashMap<>();

    public void register(User user) {

        users.put(
                user.getUsername(),
                user);

        System.out.println(
                user.getUsername()
                + " registered.");
    }

    public User login(
            String username,
            String password) {

        User user =
                users.get(username);

        if(user != null &&
           user.authenticate(password)) {

            System.out.println(
                    username + " logged in.");

            return user;
        }

        System.out.println(
                "Invalid username/password");

        return null;
    }
}
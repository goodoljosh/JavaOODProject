public class UserDAO {

    public boolean login(String username, String password) {

        return username.equals("admin")
            && password.equals("password");
    }
}
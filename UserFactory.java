import java.util.UUID;

// FACTORY PATTERN: creates the requested type of FreshCart user.
public class UserFactory {
    public static User createUser(String role, String name, String email) {
        if (role == null) {
            throw new IllegalArgumentException("User role is required.");
        }

        String id = UUID.randomUUID().toString();

        switch (role.trim().toUpperCase()) {
            case "CUSTOMER":
                return new Customer(id, name, email);
            case "ADMIN":
            case "ADMINISTRATOR":
                return new Administrator(id, name, email);
            default:
                throw new IllegalArgumentException("Unknown user role: " + role);
        }
    }
}

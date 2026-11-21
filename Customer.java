public class Customer extends User {
    public Customer(String userId, String name, String email) {
        super(userId, name, email);
    }

    @Override
    public String getRole() { return "CUSTOMER"; }
}

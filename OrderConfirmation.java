public class OrderConfirmation {
    public void display(Order order) {
        System.out.println("\\n========== FRESHCART ORDER CONFIRMATION ==========");
        System.out.println("Order number: " + order.getOrderNumber());
        System.out.println("Customer ID: " + order.getCustomerId());
        System.out.println("Payment status: " + order.getPaymentStatus());
        System.out.println("Payment reference: " + order.getPaymentReference());
        System.out.println("Items purchased:");

        for (CartItem item : order.getItems()) {
            System.out.println(" - " + item.getProduct().getName()
                    + " x " + item.getQuantity()
                    + " = $" + item.getSubtotal());
        }

        System.out.println("Order total: $" + order.getTotal());
        System.out.println("Thank you for shopping with FreshCart!");
        System.out.println("==================================================\\n");
    }
}

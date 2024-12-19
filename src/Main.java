public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("1", "Laptop", "Gaming beast", 900000.00, 1);
        Product p2 = new Product("2", "Doner", "Very tasty doner!", 2450.00, 1000);

        Shopper shopper = new Shopper("1", "Tamerlan Yessimov", "tamerke@example.com");

        Order order = new Order("1", shopper);
        order.addProduct(p1, 1);
        order.addProduct(p2, 5);

        shopper.addOrder(order);

        // Display order summary
        System.out.println("Order ID: " + order.getId());
        System.out.println("Shopper: " + shopper.getName());
        System.out.println("Total Amount: KZT " + order.getTotalAmount());
        System.out.println("Products:");
        order.getProducts().forEach((product, quantity) ->
                System.out.println("- " + product.getName() + ": " + quantity + " x KZT " + product.getPrice()));
    }
}
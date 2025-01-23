import java.util.*;

public class Order {
    private String id;
    private Shopper shopper;
    private Date orderDate;
    private Map<Product, Integer> products;
    private double totalAmount;

    public Order(String id, Shopper shopper) {
        this.id = id;
        this.shopper = shopper;
        this.orderDate = new Date();
        this.products = new HashMap<>();
        this.totalAmount = 0.0;
    }

    public void addProduct(Product product, int quantity) {
        if (product.getQuantity() >= quantity) {
            products.put(product, quantity);
            product.setQuantity(product.getQuantity() - quantity);
            calculateTotal();
        } else {
            System.out.println("Not enough quantity of product: " + product.getName());
        }
    }

    private void calculateTotal() {
        totalAmount = products.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return "Order{id='" + id + "', shopper=" + shopper.getName() + ", totalAmount=" + totalAmount + "}";
    }
}

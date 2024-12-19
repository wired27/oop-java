import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
            System.out.println("The product " + product.getId() + " does not have enough quantity");
        }
    }

    private void calculateTotal() {
        totalAmount = products.entrySet()
                .stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Shopper getShopper() {
        return shopper;
    }

    public void setShopper(Shopper shopper) {
        this.shopper = shopper;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
import java.util.*;
import java.util.stream.Collectors;

public class Shopper {
    private String id;
    private String name;
    private String email;
    private List<Order> orders;

    public Shopper(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> filterOrdersByAmount(double minAmount) {
        return orders.stream()
                .filter(order -> order.getTotalAmount() >= minAmount)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Shopper{id='" + id + "', name='" + name + "', email='" + email + "'}";
    }
}

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseActions {

    public void addProduct(String name, String description, double price, int quantity) {
        String sql = "INSERT INTO Product (name, description, price, quantity) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, description);
            stmt.setDouble(3, price);
            stmt.setInt(4, quantity);

            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected + " product(s) added successfully.");

        } catch (SQLException e) {
            System.out.println("Error adding product: " + e.getMessage());
        }
    }

    public List<String> getAllProducts() {
        List<String> products = new ArrayList<>();
        String sql = "SELECT * FROM Product";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String product = "ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Description: " + rs.getString("description") +
                        ", Price: $" + rs.getDouble("price") +
                        ", Quantity: " + rs.getInt("quantity");
                products.add(product);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving products: " + e.getMessage());
        }

        return products;
    }

    public List<String> searchProductsByName(String keyword) {
        List<String> products = new ArrayList<>();
        String sql = "SELECT * FROM Product WHERE name ILIKE ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + keyword + "%");

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String product = "ID: " + rs.getInt("id") +
                            ", Name: " + rs.getString("name") +
                            ", Description: " + rs.getString("description") +
                            ", Price: $" + rs.getDouble("price") +
                            ", Quantity: " + rs.getInt("quantity");
                    products.add(product);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error searching products: " + e.getMessage());
        }

        return products;
    }

    public void updateProductPrice(int id, double newPrice) {
        String sql = "UPDATE Product SET price = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, newPrice);
            stmt.setInt(2, id);

            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected + " product(s) updated successfully.");

        } catch (SQLException e) {
            System.out.println("Error updating product: " + e.getMessage());
        }
    }

    public void deleteProduct(int id) {
        String sql = "DELETE FROM Product WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected + " product(s) deleted successfully.");

        } catch (SQLException e) {
            System.out.println("Error deleting product: " + e.getMessage());
        }
    }

    public List<String> sortProductsByPrice(String order) {
        List<String> products = new ArrayList<>();
        String sql = "SELECT * FROM Product ORDER BY price " + order;

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String product = "ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Description: " + rs.getString("description") +
                        ", Price: $" + rs.getDouble("price") +
                        ", Quantity: " + rs.getInt("quantity");
                products.add(product);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving products: " + e.getMessage());
        }

        return products;
    }

    public List<String> sortProductsByName() {
        List<String> products = new ArrayList<>();
        String sql = "SELECT * FROM Product ORDER BY name";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String product = "ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Description: " + rs.getString("description") +
                        ", Price: $" + rs.getDouble("price") +
                        ", Quantity: " + rs.getInt("quantity");
                products.add(product);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving products: " + e.getMessage());
        }

        return products;
    }
}
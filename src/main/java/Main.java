import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseActions dbActions = new DatabaseActions();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Product Management System ---");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Search Products by Name");
            System.out.println("4. Update Product Price");
            System.out.println("5. Delete Product");
            System.out.println("6. Sort Products");
            System.out.println("7. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter product quantity: ");
                    int quantity = scanner.nextInt();
                    dbActions.addProduct(name, description, price, quantity);
                    break;

                case 2:
                    System.out.println("\nAll Products:");
                    dbActions.getAllProducts().forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter search keyword: ");
                    String keyword = scanner.nextLine();
                    System.out.println("\nSearch Results:");
                    dbActions.searchProductsByName(keyword).forEach(System.out::println);
                    break;

                case 4:
                    System.out.print("Enter product ID to update: ");
                    int idToUpdate = scanner.nextInt();
                    System.out.print("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    dbActions.updateProductPrice(idToUpdate, newPrice);
                    break;

                case 5:
                    System.out.print("Enter product ID to delete: ");
                    int idToDelete = scanner.nextInt();
                    dbActions.deleteProduct(idToDelete);
                    break;

                case 6:
                    System.out.println("Choose sorting option:");
                    System.out.println("1. Sort by Price");
                    System.out.println("2. Sort by Name");
                    System.out.print("Select an option: ");
                    int sortOption = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    if (sortOption == 1) {
                        System.out.println("Choose sorting order:");
                        System.out.println("1. Ascending");
                        System.out.println("2. Descending");
                        System.out.print("Select an order: ");
                        int orderOption = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        String order = (orderOption == 1) ? "ASC" : "DESC";
                        dbActions.sortProductsByPrice(order).forEach(System.out::println);
                    } else if (sortOption == 2) {
                        System.out.println("\nProducts Sorted by Name:");
                        dbActions.sortProductsByName().forEach(System.out::println);
                    } else {
                        System.out.println("Invalid option. Please try again.");
                    }
                    break;

                case 7:
                    System.out.println("Exiting...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
        scanner.close();
    }
}

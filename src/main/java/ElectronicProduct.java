public class ElectronicProduct extends Product {
    private int warrantyMonths;

    public ElectronicProduct(String id, String name, String description, double price, int quantity, int warrantyMonths) {
        super(id, name, description, price, quantity);
        this.warrantyMonths = warrantyMonths;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    @Override
    public String toString() {
        return super.toString() + " [Warranty: " + warrantyMonths + " months]";
    }
}

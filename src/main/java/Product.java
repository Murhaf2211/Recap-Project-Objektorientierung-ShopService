public record Product(
        String id,
        String name,
        double price,
        double quantity) {

    public Product {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
    }

    // Method to decrease the quantity of the product
    public void decreaseQuantity(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount to decrease must be positive.");
        }
        if (quantity < amount) {
            throw new IllegalArgumentException("Not enough stock for product: " + id);
        }
        new Product(id, name, price, quantity - amount);
    }

    // Method to check if product is in stock
    public boolean isAvailable() {
        return quantity > 0;
    }
}
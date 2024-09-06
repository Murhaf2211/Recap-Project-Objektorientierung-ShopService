
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductRepo productRepo = new ProductRepo();
        OrderRepo orderRepo = new OrderMapRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);

        // Adding some products
        productRepo.addProduct(new Product("P1", "Product 1", 10.0, 5.0));
        productRepo.addProduct(new Product("P2", "Product 2", 15.0, 2.0));
        productRepo.addProduct(new Product("P3", "Product 3", 20.0, 8.0));

        // Create new orders
        Order order1 = shopService.addOrder(List.of("P1", "P2"));
        Order order2 = shopService.addOrder(List.of("P3"));

        // Print all orders
        shopService.printOrders();

        // Print all completed orders
        List<Order> completedOrders = shopService.getOrdersByStatus(OrderStatus.COMPLETED);
        System.out.println("Completed Orders: " + completedOrders);
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


public class ShopService {
    private final ProductRepo productRepo = new ProductRepo();
    private final OrderRepo orderRepo = new OrderMapRepo();

    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {

    }


    // Method to add a new order
    public Order addOrder(List<String> productIds) {
        List<Product> products = new ArrayList<>();

        for (String productId : productIds) {
            Product productToOrder = productRepo.getProductById(productId)
                    .orElseThrow(() -> new IllegalArgumentException("Product with ID " + productId + " does not exist."));

            productToOrder.decreaseQuantity(1); // Assuming ordering 1 unit
            products.add(productToOrder);
        }

        Order newOrder = new Order(UUID.randomUUID().toString(), products);
        return orderRepo.addOrder(newOrder);
    }
    
    // Method to return orders filtered by a specific status
    public List<Order> getOrdersByStatus(OrderStatus status) {
        return orderRepo.getAllOrders().stream()
                .filter(order -> order.status() == status)
                .collect(Collectors.toList());
    }


    // Method to print all orders (for demonstration purposes)
    public void printOrders() {
        orderRepo.getAllOrders().forEach(System.out::println);
    }

}
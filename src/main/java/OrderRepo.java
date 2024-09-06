import java.util.List;

public interface OrderRepo {
    Order addOrder(Order order);
    Order getOrderById(String id);
    List<Order> getAllOrders();

    List<Order> getOrders();

     void updateOrder(Order order);

    void removeOrder(String id);
}
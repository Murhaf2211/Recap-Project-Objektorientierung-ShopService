import java.util.*;

public class OrderMapRepo implements OrderRepo {
    private  Map<String, Order> orders = new HashMap<>();

    @Override
    public Order addOrder(Order order) {
        orders.put(order.id(), order);
        return order;
    }

    @Override
    public Order getOrderById(String id) {
        return orders.get(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return List.of();
    }

    @Override
    public List<Order> getOrders() {
        return new ArrayList<>(orders.values());
    }

    @Override
    public void updateOrder(Order updatedOrder) {
        orders.put(updatedOrder.id(), updatedOrder);
    }
    @Override
    public void removeOrder(String id) {
        orders.remove(id);
    }
}
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderListRepo implements OrderRepo{
    private final List<Order> orders = new ArrayList<>();

    public Order getOrderById(String id) {
        for (Order order : orders) {
            if (order.id().equals(id)) {
                return order;
            }
        }
        return null;
    }
    public List<Order> getAllOrders() {
        return List.of();
    }

    @Override
    public void updateOrder(Order order) {

    }

    public Order addOrder(Order newOrder) {
        orders.add(newOrder);
        return newOrder;
    }
    public void removeOrder(String id) {
        for (Order order : orders) {
            if (order.id().equals(id)) {
                orders.remove(order);
                return;
            }
        }
    }
}

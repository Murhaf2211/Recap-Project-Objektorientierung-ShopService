import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OrderMapRepoTest {

    @Test
    void getOrderById() {
        //GIVEN
        OrderMapRepo repo = new OrderMapRepo();

        Product product = new Product("1", "Apfel",20,2);
        Order newOrder = new Order("1", List.of(product));
        repo.addOrder(newOrder);

        //WHEN
        Optional<Order> actual = Optional.ofNullable(repo.getOrderById("1"));

        //THEN
        Product product1 = new Product("1", "Apfel",20,2);
        Order expected = new Order("1", List.of(product1));

        assertEquals(actual, expected);
    }

    @Test
    void addOrder() {
        //GIVEN
        OrderMapRepo repo = new OrderMapRepo();
        Product product = new Product("1", "Apfel",20,2);
        Order newOrder = new Order("1", List.of(product));

        //WHEN
        Order actual = repo.addOrder(newOrder);

        //THEN
        Product product1 = new Product("1", "Apfel",20,2);
        Order expected = new Order("1", List.of(product1));
        assertEquals(actual, expected);
        assertEquals(repo.getOrderById("1"), expected);
    }

}

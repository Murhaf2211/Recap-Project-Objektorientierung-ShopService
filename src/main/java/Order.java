import lombok.With;
import java.time.LocalDateTime;
import java.util.List;

public record Order(
        String id,
        List<Product> products,
        @With OrderStatus status,
        LocalDateTime orderTimestamp)
{
    public Order(String id, List<Product> products) {
        this(id, products, OrderStatus.PROCESSING, LocalDateTime.now());
    }
}
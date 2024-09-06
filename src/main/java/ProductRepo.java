import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class ProductRepo {
    private List<Product> products = new ArrayList<>();

    public ProductRepo() {
        products = new ArrayList<>();
        products.add(new Product("1", "Apfel",22,2));
    }

    public Optional<Product> getProductById(String productId) {
        return products.stream()
                .filter(product -> product.id().equals(productId))
                .findFirst();
    }

    public Product addProduct(Product product) {
        products.add(product);
        return product;
    }
    public void removeProduct(String id) {
        for (Product product : products) {
            if (product.id().equals(id)) {
                products.remove(product);
                return;
            }
        }
    }
}
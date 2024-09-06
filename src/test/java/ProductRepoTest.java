import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {


    @org.junit.jupiter.api.Test
    void getProductById() {
        //GIVEN
        ProductRepo repo = new ProductRepo();

        //WHEN
        Optional<Product> actual = repo.getProductById("1");

        //THEN
        Product expected = new Product("1", "Apfel",20,2);
        assertEquals(actual, expected);
    }

    @org.junit.jupiter.api.Test
    void addProduct() {
        //GIVEN
        ProductRepo repo = new ProductRepo();
        Product newProduct = new Product("2", "Banane",20,2);

        //WHEN
        Product actual = repo.addProduct(newProduct);

        //THEN
        Product expected = new Product("2", "Banane",20,2);
        assertEquals(actual, expected);
        assertEquals(repo.getProductById("2"), expected);
    }
}

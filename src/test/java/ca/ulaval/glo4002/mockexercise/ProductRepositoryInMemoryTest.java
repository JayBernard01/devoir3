package ca.ulaval.glo4002.mockexercise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ProductRepositoryInMemoryTest {
    private ProductRepositoryInMemory productRepositoryInMemory = new ProductRepositoryInMemory();

    @Test
    public void givenAProductInInventory_whenFindingThatProduct_thenTheProductIsReturned(){
        Product product = new Product("123456", "clavier", 50.0);
        String expectedSku = "123456";
        productRepositoryInMemory.saveProduct(product);

        Product sameProduct = productRepositoryInMemory.findBySku(product.getSku());

        assertEquals(sameProduct.getSku(), expectedSku);
    }

    @Test
    public void givenAProductNotInInventory_whenFindingThatProduct_thenProductNotFound(){
        Product product = new Product("-1", "clavier", 50.0);
        assertThrows(NoProductFoundException.class, () -> {
            productRepositoryInMemory.findBySku(product.getSku());
        });
    }
}

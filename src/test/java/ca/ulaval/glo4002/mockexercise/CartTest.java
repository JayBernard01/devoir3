package ca.ulaval.glo4002.mockexercise;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ca.ulaval.glo4002.mockexercise.do_not_edit.Invoice;

public class CartTest {
    Cart cart = new Cart("allo@gmai.com");

    @Test
    public void whenAddingProductToCart_thenReturnInvoice() {
        Product product = new Product("1", "test1", 1.0);
        Invoice invoice;

        invoice = cart.addProduct(product);

        assertNotEquals(null, invoice);
    }

    @Test
    public void whenNotAddingProductToCart_thenRejectInvoice(){
        assertThrows(NoProductFoundException.class, () -> {
            cart.addProduct(null);
        });
    }
}

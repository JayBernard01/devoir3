package ca.ulaval.glo4002.mockexercise;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ca.ulaval.glo4002.mockexercise.do_not_edit.CartFactory;
import ca.ulaval.glo4002.mockexercise.do_not_edit.Invoice;

@ExtendWith(MockitoExtension.class)
public class StartByTestingThisTest {

    @InjectMocks
    private StartByTestingThis service;

    //a call to a repository requires more setup and test time, so we mock to avoid it
    @Mock
    private ProductRepositoryInMemory productRepositoryInMemory;

    //we could simulate different contexts, but you could use the real inputs as black-box easily without setup
    private CartFactory cartFactory = new CartFactory();

    private String expectedEmail = "allo@gmail.com";
    private String foundProductSku = "1";
    private String notFoundProductSku = "-1";
    private Double expectedPrice = 1.0;

    
    @BeforeEach
    public void setUp() {
        service = new StartByTestingThis(productRepositoryInMemory, cartFactory);

    }

    @Test
    public void whenBuyingProduct_thenReceiveInvoice() {
        Product expectedFoundProduct = new Product(foundProductSku, expectedEmail, expectedPrice);
        when(productRepositoryInMemory.findBySku(notFoundProductSku)).thenReturn(expectedFoundProduct);
        Invoice invoice;
        
        invoice = service.oneClickBuy(expectedEmail, notFoundProductSku);

        assertNotEquals(null, invoice);
    }

    @Test
    public void givenNoneExistantProduct_whenBuyingProduct_thenRejectInvoice() {
        when(productRepositoryInMemory.findBySku(notFoundProductSku))
            .thenThrow(new NoProductFoundException(notFoundProductSku));

        assertThrows(NoProductFoundException.class, () -> {
            service.oneClickBuy(expectedEmail, notFoundProductSku);
        });
    }
}

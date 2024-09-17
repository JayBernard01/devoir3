package ca.ulaval.glo4002.mockexercise;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ca.ulaval.glo4002.mockexercise.do_not_edit.CartFactory;

public class CartFactoryTest {
    private CartFactory cartFactory = new CartFactory();

    //test plus ou moins pertinent, il faudrait vérifier le email ici plutôt et lancer une excpetion si invalide
    @Test
    public void givenEmail_whenCreatingCart_thenCartIsCreated()
    {
        String email = "allo@gmail.com";
        Cart cart = new Cart(email);
        Cart expectedCart;

        expectedCart = cartFactory.create(email);

        assertEquals(cart.getEmail(), expectedCart.getEmail());
    }
}

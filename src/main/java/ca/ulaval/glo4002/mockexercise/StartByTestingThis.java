package ca.ulaval.glo4002.mockexercise;

import ca.ulaval.glo4002.mockexercise.do_not_edit.CartFactory;
import ca.ulaval.glo4002.mockexercise.do_not_edit.Invoice;

public class StartByTestingThis {

    private ProductRepositoryInMemory productRepositoryInMemory;
    private CartFactory cartFactory;

    public StartByTestingThis(ProductRepositoryInMemory productRepositoryInMemory, CartFactory cartFactory) {
        this.productRepositoryInMemory = productRepositoryInMemory;
        this.cartFactory = cartFactory;
    }

    public Invoice oneClickBuy(String clientEmail, String productSku) {
        // Étape 1 : Créer le cart avec le CartFactory
        Cart cart = cartFactory.create(clientEmail);
        Invoice invoice;

        // Étape 3 : Ajouter le produit au cart
        // Étape 4 : Pour chaque item du cart, ajouter une ligne sur l'invoice
        // Étape 5 : Retourner l'invoice
        invoice = cart.addProduct(productRepositoryInMemory.findBySku(productSku));
        return invoice;
    }
}

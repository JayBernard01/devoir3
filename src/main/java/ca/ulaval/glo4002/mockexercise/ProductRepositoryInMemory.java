package ca.ulaval.glo4002.mockexercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ca.ulaval.glo4002.mockexercise.do_not_edit.ProductRepository;

public class ProductRepositoryInMemory implements ProductRepository {

    List<Product> productInventory = new ArrayList<Product>();

    @Override
    public Product findBySku(String sku) {

       Optional<Product> foundProduct = productInventory
            .stream()
            .filter(product -> product.getSku() == sku).findFirst();
        
        if (foundProduct.isPresent()){
            return foundProduct.get();
        }
        throw new NoProductFoundException(sku);
    }

    public void saveProduct(Product product) {
        productInventory.add(product);
    }

}

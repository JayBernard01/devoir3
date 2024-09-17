package ca.ulaval.glo4002.mockexercise;

import java.util.ArrayList;
import java.util.List;

import ca.ulaval.glo4002.mockexercise.do_not_edit.Invoice;
import ca.ulaval.glo4002.mockexercise.do_not_edit.InvoiceLine;

public class Cart {
    private final String email;
    private final List<Product> products = new ArrayList<>();

    public Cart(String email) {
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public Invoice addProduct(Product product) {
        if (product == null) {
            throw new NoProductFoundException("you cannot add an empty product to cart");
        }
        this.products.add(product);
        List<InvoiceLine> invoiceLines = new ArrayList<>();
        for (Product item : products) {
            invoiceLines.add(new InvoiceLine(item.getName(), item.getPrice()));
        }
        return new Invoice(email, invoiceLines);
    }

    public List<Product> getProducts() {
        return products;
    }




}

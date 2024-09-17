package ca.ulaval.glo4002.mockexercise;

public class NoProductFoundException extends RuntimeException {
    NoProductFoundException(String sku){
        super("No Product found for this sku: " + sku);
    }
}

package edu.eci.arsw.saleit.model;

public class SaleItException extends Exception {

    public SaleItException(String message) {
        super(message);
    }

    public SaleItException(String message, Throwable cause) {
        super(message, cause);
    }
}

package edu.eci.arsw.saleit.persistence;

public class SaleItPersistenceException extends Exception{

    public SaleItPersistenceException (String message) {super(message);}

    public SaleItPersistenceException (String message, Throwable cause) {
        super(message, cause);
    }
}

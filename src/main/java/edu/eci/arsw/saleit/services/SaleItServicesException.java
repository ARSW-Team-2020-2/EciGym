package edu.eci.arsw.saleit.services;

public class SaleItServicesException extends Exception{

    public SaleItServicesException(String message) {super(message);}

    public SaleItServicesException(String message, Throwable cause) {
        super(message, cause);
    }

}

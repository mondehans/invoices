package net.monde.hans.invoices.rest.util;

public class InvoiceNotFoundException extends RuntimeException {

public InvoiceNotFoundException(String message){
    super(message);
}
}

package net.monde.hans.invoices.services;

import net.monde.hans.invoices.model.Invoice;

import java.util.List;

public interface InvoicesService {

    public List<Invoice> getInvoices();
    public Invoice getInvoice(Long id);
    public Invoice addInvoice(Invoice invoice);

}

package net.monde.hans.invoices.rest;


import net.monde.hans.invoices.model.Invoice;
import net.monde.hans.invoices.rest.util.InvalidInputException;
import net.monde.hans.invoices.services.InvoicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Invoices {

    @Autowired
    private InvoicesService invoicesService;

    @GetMapping("/invoices")
    public List<Invoice> getInvoices() {
        return invoicesService.getInvoices();
    }

    @GetMapping("/invoices/{id}")
    public Invoice getInvoice(@PathVariable Long id) {
        return invoicesService.getInvoice(id);
    }

    @PostMapping("/invoices")
   public Invoice addInvoice(@RequestBody Invoice invoice){
        return invoicesService.addInvoice(invoice);
    }


}

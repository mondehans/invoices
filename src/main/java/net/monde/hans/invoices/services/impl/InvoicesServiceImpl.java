package net.monde.hans.invoices.services.impl;

import net.monde.hans.invoices.data.InvoiceRepository;
import net.monde.hans.invoices.data.LineItemRepository;
import net.monde.hans.invoices.model.Invoice;
import net.monde.hans.invoices.rest.util.InvalidInputException;
import net.monde.hans.invoices.rest.util.InvoiceNotFoundException;
import net.monde.hans.invoices.services.InvoicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class InvoicesServiceImpl implements InvoicesService{


    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private LineItemRepository lineItemRepository;

    @Override
    public List<Invoice> getInvoices() {

        List<Invoice> invoices = new ArrayList<>();
        Iterable<Invoice> iterable = invoiceRepository.findAll();
        iterable.forEach(invoices::add);
        return invoices;
    }

    @Override
    public Invoice getInvoice(Long id) {

        Optional<Invoice> byId = invoiceRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        }
        throw new InvoiceNotFoundException("Invoice not found ");
    }

    @Override
    public Invoice addInvoice(Invoice invoice) {

      if (Objects.isNull(invoice) || Objects.isNull(invoice.getLineItems())){
          throw new InvalidInputException("No invoice or line items specified.");
      }

       invoice.getLineItems().forEach(x -> x.setInvoice(invoice));
        return invoiceRepository.save(invoice);
    }
}

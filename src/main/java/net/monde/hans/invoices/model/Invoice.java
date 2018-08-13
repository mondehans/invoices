package net.monde.hans.invoices.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Invoice implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String client;

    private Long vatRate;

    private Date invoiceDate;

    @OneToMany(mappedBy="invoice", cascade = CascadeType.ALL)
    private List<LineItem> lineItems;

    public Long getId() {
        return id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Long getVatRate() {
        return vatRate;
    }

    public void setVatRate(Long vatRate) {
        this.vatRate = vatRate;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", client='" + client + '\'' +
                ", vatRate=" + vatRate +
                ", invoiceDate=" + invoiceDate +
                ", lineItems=" + lineItems +
                '}';
    }
}

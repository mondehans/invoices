package net.monde.hans.invoices.model;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class LineItem implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long quantity;

    private String description;

    private BigDecimal unitPrice;

    @ManyToOne
    @JoinColumn(name="INVOICE_ID")
    private Invoice invoice;

    public Long getId() {
        return id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
     public void setInvoice(Invoice invoice){
        this.invoice=invoice;
     }

    @Override
    public String toString() {
        return "LineItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}

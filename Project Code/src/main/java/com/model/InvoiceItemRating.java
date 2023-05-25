package com.model;

import javax.persistence.*;

@Entity
@Table(name = "invoice_item_rating")
public class InvoiceItemRating {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "invoice_item_id")
    private int invoice_item_id;

    @Column(name = "rating_id")
    private int rating_id;

    public int getId() {
        return id;
    }

    public int getInvoice_item_id() {
        return invoice_item_id;
    }

    public int getRating_id() {
        return rating_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRating_id(int rating_id) {
        this.rating_id = rating_id;
    }

    public void setInvoice_item_id(int invoice_item_id) {
        this.invoice_item_id = invoice_item_id;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}


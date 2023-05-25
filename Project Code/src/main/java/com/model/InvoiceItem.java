package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "invoice_item")
public class InvoiceItem {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "invoice_id")
    private int invoice_id;

    @Column(name = "menu_id")
    private int menu_id;

    @Column(name = "quantity")
    private int quantity;

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}


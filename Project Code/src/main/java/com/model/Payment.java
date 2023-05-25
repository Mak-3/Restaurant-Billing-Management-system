package com.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "invoice_id")
    private int invoice_id;

    @Column(name = "customer_id")
    private int customer_id;

    @Column(name = "payment_date")
    private Date payment_date;

    @Column(name = "payment_type_id")
    private int payment_type_id;

    @Column(name = "total_amount")
    private float total_amount;

    public float getTotal_amount() {
        return total_amount;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public int getId() {
        return id;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public int getPayment_type_id() {
        return payment_type_id;
    }

    public void setTotal_amount(float total_amount) {
        this.total_amount = total_amount;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public void setPayment_type_id(int payment_type_id) {
        this.payment_type_id = payment_type_id;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "taxes_and_charges")
public class Taxes {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "cgst")
    private float cgst;
    @Column(name = "sgst")
    private float sgst;
    @Column(name = "convinience_fee")
    private float convinience_fee;

    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }

    public float getCgst() {
        return cgst;
    }

    public float getConvinience_fee() {
        return convinience_fee;
    }

    public float getSgst() {
        return sgst;
    }

    public void setCgst(float cgst) {
        this.cgst = cgst;
    }

    public void setConvinience_fee(float convinience_fee) {
        this.convinience_fee = convinience_fee;
    }

    public void setSgst(float sgst) {
        this.sgst = sgst;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

package com.model;

import javax.persistence.*;
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "phone_no")
    private String phone_no;

    @Column(name = "customer_name")
    private String customer_name;

    public int getId() {
        return id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", phone_no='" + phone_no + '\'' +
                ", customer_name='" + customer_name + '\'' +
                '}';
    }
}

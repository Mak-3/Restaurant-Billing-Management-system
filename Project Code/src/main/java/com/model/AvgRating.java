package com.model;

import javax.persistence.*;

@Entity
@Table(name = "avg_dish_rating")
public class AvgRating {

    @Column(name = "id")
    private int id;
    @Id
    @Column(name = "menu_id")
    private int menu_id;

    @Column(name = "customercount")
    private int customercount;

    @Column(name = "avg_rating")
    private float avg_rating;

    public int getId() {
        return id;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public float getAvg_rating() {
        return avg_rating;
    }

    public int getCustomercount() {
        return customercount;
    }

    public void setCustomercount(int customercount) {
        this.customercount = customercount;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public void setAvg_rating(float avg_rating) {
        this.avg_rating = avg_rating;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

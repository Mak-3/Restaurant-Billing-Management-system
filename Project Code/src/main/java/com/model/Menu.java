package com.model;

import javax.persistence.*;

@Entity
@Table(name="menu")
public class Menu {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "food_type_id")
    private int food_type_id;
    @Column(name = "image_path")
    private String image_path;
    @Column(name = "dish_name")
    private String dish_name;

    @Column(name = "is_veg")
    private boolean is_veg;

    @Column(name = "price")
    private float price;

    @Column(name = "is_available")
    private  boolean is_available;

    public float getPrice() {
        return price;
    }

    public int getFood_type_id() {
        return food_type_id;
    }

    public String getDish_name() {
        return dish_name;
    }

    public int getId() {
        return id;
    }

    public boolean isIs_veg() {
        return is_veg;
    }

    public boolean isIs_available() {
        return is_available;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }

    public void setFood_type_id(int food_type_id) {
        this.food_type_id = food_type_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIs_available(boolean is_available) {
        this.is_available = is_available;
    }

    public void setIs_veg(boolean is_veg) {
        this.is_veg = is_veg;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}


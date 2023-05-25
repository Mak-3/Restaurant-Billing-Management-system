package com.model;

import javax.persistence.*;

@Entity
@Table(name = "user_review")
public class UserReview {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "invoice_id")
    private int invoice_id;

    @Column(name = "comments")
    private String comments;

    @Column(name = "rating_id")
    private int rating_id;

    public int getRating_id() {
        return rating_id;
    }

    public int getId() {
        return id;
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public void setRating_id(int rating_id) {
        this.rating_id = rating_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

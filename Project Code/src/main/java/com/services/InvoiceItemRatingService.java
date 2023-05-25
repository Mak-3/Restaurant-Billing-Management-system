package com.services;

import com.model.InvoiceItemRating;

import java.util.List;

public interface InvoiceItemRatingService {
    List<InvoiceItemRating> getInvoiceItemRating();

    InvoiceItemRating createInvoiceItemRating(InvoiceItemRating invoiceItemRating);
    InvoiceItemRating getInvoiceItemRatingById(int id);

    InvoiceItemRating updateInvoiceItemRating(InvoiceItemRating invoiceItemRating);

    InvoiceItemRating deleteInvoiceItemRatingById(int id);
}

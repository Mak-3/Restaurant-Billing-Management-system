package com.services;

import com.model.Invoice;

import java.util.List;

public interface InvoiceService {
    List<Invoice> getInvoice();

    Invoice createInvoice(Invoice invoice);
    Invoice getInvoiceById(int id);

    Invoice updateInvoice(Invoice invoice);

    Invoice deleteInvoiceById(int id);
}

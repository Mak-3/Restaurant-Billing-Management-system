package com.services;

import com.model.InvoiceItemRating;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceItemRatingServiceImpl implements InvoiceItemRatingService{
    @Autowired
    private SessionFactory sessionFactory;

    public List<InvoiceItemRating> getInvoiceItemRating() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<InvoiceItemRating> invoiceItemRatingList = session.createQuery("from InvoiceItemRating",InvoiceItemRating.class).list();
        transaction.commit();
        session.close();
        return invoiceItemRatingList;
    }

    public InvoiceItemRating createInvoiceItemRating(InvoiceItemRating invoiceItemRating) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(invoiceItemRating);
        transaction.commit();
        session.close();
        return invoiceItemRating;
    }

    public InvoiceItemRating getInvoiceItemRatingById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        InvoiceItemRating invoiceItemRating = session.get(InvoiceItemRating.class,id);
        transaction.commit();
        session.close();
        return invoiceItemRating;
    }

    public InvoiceItemRating updateInvoiceItemRating(InvoiceItemRating invoiceItemRating){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(invoiceItemRating);
        transaction.commit();
        session.close();
        return invoiceItemRating;
    }

    public InvoiceItemRating deleteInvoiceItemRatingById(int id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        InvoiceItemRating invoiceItemRating = session.get(InvoiceItemRating.class,id);
        session.delete(invoiceItemRating);
        transaction.commit();
        session.close();
        return invoiceItemRating;
    }
}

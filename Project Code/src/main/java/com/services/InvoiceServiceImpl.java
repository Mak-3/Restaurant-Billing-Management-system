package com.services;

import com.model.Invoice;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService{
    @Autowired
    private SessionFactory sessionFactory;

    public List<Invoice> getInvoice() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Invoice> InvoiceList = session.createQuery("from Invoice",Invoice.class).list();
        transaction.commit();
        session.close();
        return InvoiceList;
    }

    public Invoice createInvoice(Invoice Invoice) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(Invoice);
        transaction.commit();
        session.close();
        return Invoice;
    }

    public Invoice getInvoiceById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Invoice Invoice = session.get(Invoice.class,id);
        transaction.commit();
        session.close();
        return Invoice;
    }

    public Invoice updateInvoice(Invoice Invoice){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(Invoice);
        transaction.commit();
        session.close();
        return Invoice;
    }

    public Invoice deleteInvoiceById(int id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Invoice Invoice = session.get(Invoice.class,id);
        session.delete(Invoice);
        transaction.commit();
        session.close();
        return Invoice;
    }
}

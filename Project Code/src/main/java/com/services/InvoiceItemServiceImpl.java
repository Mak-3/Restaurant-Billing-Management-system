package com.services;

import com.model.InvoiceItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceItemServiceImpl implements InvoiceItemService{
    @Autowired
    private SessionFactory sessionFactory;

    public List<InvoiceItem> getInvoiceItem() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<InvoiceItem> invoiceItemList = session.createQuery("from InvoiceItem",InvoiceItem.class).list();
        transaction.commit();
        session.close();
        return invoiceItemList;
    }

    public InvoiceItem createInvoiceItem(InvoiceItem invoiceItem) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(invoiceItem);
        transaction.commit();
        session.close();
        return invoiceItem;
    }

    public InvoiceItem getInvoiceItemById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        InvoiceItem invoiceItem = session.get(InvoiceItem.class,id);
        transaction.commit();
        session.close();
        return invoiceItem;
    }

    public InvoiceItem updateInvoiceItem(InvoiceItem invoiceItem){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(invoiceItem);
        transaction.commit();
        session.close();
        return invoiceItem;
    }

    public InvoiceItem deleteInvoiceItemById(int id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        InvoiceItem invoiceItem = session.get(InvoiceItem.class,id);
        session.delete(invoiceItem);
        transaction.commit();
        session.close();
        return invoiceItem;
    }
}

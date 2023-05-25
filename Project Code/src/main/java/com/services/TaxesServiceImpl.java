package com.services;

import com.model.Taxes;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxesServiceImpl implements TaxesService{
    @Autowired
    private SessionFactory sessionFactory;

    public List<Taxes> getTaxes() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Taxes> taxesList = session.createQuery("from Taxes",Taxes.class).list();
        transaction.commit();
        session.close();
        return taxesList;
    }

    public Taxes createTaxes(Taxes taxes) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(taxes);
        transaction.commit();
        session.close();
        return taxes;
    }

    public Taxes getTaxesById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Taxes taxes = session.get(Taxes.class,id);
        transaction.commit();
        session.close();
        return taxes;
    }

    public Taxes updateTaxes(Taxes taxes){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(taxes);
        transaction.commit();
        session.close();
        return taxes;
    }

    public Taxes deleteTaxesById(int id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Taxes taxes = session.get(Taxes.class,id);
        session.delete(taxes);
        transaction.commit();
        session.close();
        return taxes;
    }
}

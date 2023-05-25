package com.services;

import com.model.Payment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private SessionFactory sessionFactory;

    public List<Payment> getPayment() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Payment> paymentList = session.createQuery("from Payment",Payment.class).list();
        transaction.commit();
        session.close();
        return paymentList;
    }

    public Payment createPayment(Payment payment) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(payment);
        transaction.commit();
        session.close();
        return payment;
    }

    public Payment getPaymentById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Payment payment = session.get(Payment.class,id);
        transaction.commit();
        session.close();
        return payment;
    }

    public Payment updatePayment(Payment payment){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(payment);
        transaction.commit();
        session.close();
        return payment;
    }

    public Payment deletePaymentById(int id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Payment payment = session.get(Payment.class,id);
        session.delete(payment);
        transaction.commit();
        session.close();
        return payment;
    }
}

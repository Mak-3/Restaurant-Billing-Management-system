package com.services;

import com.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private SessionFactory sessionFactory;

    public List<Customer> getCustomer() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Customer> customerList = session.createQuery("from Customer",Customer.class).list();
        transaction.commit();
        session.close();
        return customerList;
    }

    public Customer createCustomer(Customer customer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
        return customer;
    }

    public Customer getCustomerById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class,id);
        transaction.commit();
        session.close();
        return customer;
    }

    public Customer updateCustomer(Customer customer){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(customer);
        transaction.commit();
        session.close();
        return customer;
    }

    public Customer deleteCustomerById(int id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class,id);
        session.delete(customer);
        transaction.commit();
        session.close();
        return customer;
    }
}


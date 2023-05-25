package com.services;

import com.model.AvgRating;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvgRatingServiceImpl implements AvgRatingService{
    @Autowired
    private SessionFactory sessionFactory;

    public List<AvgRating> getAvgRating() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<AvgRating> avgRatingList = session.createQuery("from AvgRating",AvgRating.class).list();
        transaction.commit();
        session.close();
        return avgRatingList;
    }

    public AvgRating createAvgRating(AvgRating avgRating) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(avgRating);
        transaction.commit();
        session.close();
        return avgRating;
    }

    public AvgRating getAvgRatingById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        AvgRating avgRating = session.get(AvgRating.class,id);
        transaction.commit();
        session.close();
        return avgRating;
    }

    public AvgRating updateAvgRating(AvgRating avgRating){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(avgRating);
        transaction.commit();
        session.close();
        return avgRating;
    }

    public AvgRating deleteAvgRatingById(int id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        AvgRating avgRating = session.get(AvgRating.class,id);
        session.delete(avgRating);
        transaction.commit();
        session.close();
        return avgRating;
    }
}

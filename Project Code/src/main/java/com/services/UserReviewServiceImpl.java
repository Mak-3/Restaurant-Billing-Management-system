package com.services;

import com.model.UserReview;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserReviewServiceImpl implements UserReviewService{
    @Autowired
    private SessionFactory sessionFactory;

    public List<UserReview> getUserReview() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<UserReview> userReviewList = session.createQuery("from UserReview",UserReview.class).list();
        transaction.commit();
        session.close();
        return userReviewList;
    }

    public UserReview createUserReview(UserReview userReview) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(userReview);
        transaction.commit();
        session.close();
        return userReview;
    }

    public UserReview getUserReviewById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        UserReview userReview = session.get(UserReview.class,id);
        transaction.commit();
        session.close();
        return userReview;
    }

    public UserReview updateUserReview(UserReview userReview){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(userReview);
        transaction.commit();
        session.close();
        return userReview;
    }

    public UserReview deleteUserReviewById(int id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        UserReview userReview = session.get(UserReview.class,id);
        session.delete(userReview);
        transaction.commit();
        session.close();
        return userReview;
    }
}

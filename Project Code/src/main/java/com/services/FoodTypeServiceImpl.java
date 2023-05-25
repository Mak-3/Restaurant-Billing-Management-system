package com.services;

import com.model.FoodType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodTypeServiceImpl implements FoodTypeService{
    @Autowired
    private SessionFactory sessionFactory;

    public List<FoodType> getFoodType() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<FoodType> foodTypeList = session.createQuery("from FoodType",FoodType.class).list();
        transaction.commit();
        session.close();
        return foodTypeList;
    }

    public FoodType createFoodType(FoodType foodType) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(foodType);
        transaction.commit();
        session.close();
        return foodType;
    }

    public FoodType getFoodTypeById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        FoodType foodType = session.get(FoodType.class,id);
        transaction.commit();
        session.close();
        return foodType;
    }

    public FoodType updateFoodType(FoodType foodType){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(foodType);
        transaction.commit();
        session.close();
        return foodType;
    }

    public FoodType deleteFoodTypeById(int id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        FoodType foodType = session.get(FoodType.class,id);
        session.delete(foodType);
        transaction.commit();
        session.close();
        return foodType;
    }
}

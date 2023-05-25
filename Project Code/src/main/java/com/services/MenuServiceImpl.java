package com.services;

import com.model.Menu;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{
    @Autowired
    private SessionFactory sessionFactory;

    public List<Menu> getMenu() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Menu> menuList = session.createQuery("from Menu",Menu.class).list();
        transaction.commit();
        session.close();
        return menuList;
    }

    public Menu createMenu(Menu menu) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(menu);
        transaction.commit();
        session.close();
        return menu;
    }

    public Menu getMenuById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Menu menu = session.get(Menu.class,id);
        transaction.commit();
        session.close();
        return menu;
    }

    public Menu updateMenu(Menu menu){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(menu);
        transaction.commit();
        session.close();
        return menu;
    }
    public Menu deleteMenuById(int id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Menu menu = session.get(Menu.class,id);
        session.delete(menu);
        transaction.commit();
        session.close();
        return menu;
    }
}

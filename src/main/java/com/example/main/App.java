package com.example.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.entity.User;
import com.example.util.HibernateUtil;

public class App {

    public static void main(String[] args) {

        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            User user = new User("Aditi", "aditi@example.com");
            session.save(user);

            tx.commit();
            System.out.println("User inserted successfully!");

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
            HibernateUtil.getSessionFactory().close();
        }
    }
}

package com.collage.students.fouryearscollage;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateUtility {

    public HibernateUtility(){

    }
    private static Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

    private static SessionFactory sessionFactory = configuration.buildSessionFactory();

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}

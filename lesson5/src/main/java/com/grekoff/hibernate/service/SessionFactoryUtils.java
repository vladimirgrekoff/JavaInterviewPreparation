package com.grekoff.hibernate.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtils {

    private static volatile SessionFactory factory;


    public synchronized static void init(){
        if (factory == null) {
            factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();
        }
    }


    public static Session getSession() {
        return factory.getCurrentSession();
    }

    public static void shutdown(){
        if(factory != null) {
            factory.close();
        }
    }
}

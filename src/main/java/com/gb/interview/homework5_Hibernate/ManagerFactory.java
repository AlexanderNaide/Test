package com.gb.interview.homework5_Hibernate;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;

public class ManagerFactory {
    private static EntityManagerFactory entityFactory;

    public static EntityManagerFactory getEntityManagerFactory(){
        if (entityFactory == null){
            entityFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();
        }
        return entityFactory;
    }

    public static void shutdown(){
        if(entityFactory != null){
            entityFactory.close();
        }
    }
}

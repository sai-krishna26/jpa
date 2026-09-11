package com.xworkz.Quick.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryUtil {

    private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("Quick");

    public static EntityManagerFactory getEntityManagerFactory()
    {
        return emf;
    }
}

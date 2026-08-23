package com.xworkz.redbus.runner;

import com.xworkz.redbus.entity.SignUpEntity;

import javax.persistence.*;

public class CreateSignUp {

    public static void main(String[] args) {
        SignUpEntity signUpEntity = new SignUpEntity();
        signUpEntity.setEmail("xworkz@gmail.com");
        signUpEntity.setName("xworkz");
        signUpEntity.setPassword("xworkz");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try
        {
            emf = Persistence.createEntityManagerFactory("efg");//load, register, connection
            em = emf.createEntityManager();//DML, DQL
            et = em.getTransaction(); //TCL
            et.begin(); //setautocommit=0
            em.persist(signUpEntity);//DMl-Insert,Update,Delete
            et.commit();
        }
        catch (PersistenceException e)
        {
            et.rollback();
            e.getMessage();
        }
        finally
        {
            if(emf!=null)
            {
                emf.close();
            }
            if(em!=null)
            {
                em.close();
            }
        }
    }
}

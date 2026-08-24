package com.xworkz.redbus.runner.create;

import com.xworkz.redbus.entity.SignUpEntity;

import javax.persistence.*;

public class CreateSignUp {

    public static void main(String[] args) {
        SignUpEntity signUpEntity = new SignUpEntity();

        signUpEntity.setEmail("krishna@gmail.com");
        signUpEntity.setName("krishna");
        signUpEntity.setPassword("krishna");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try
        {
            emf = Persistence.createEntityManagerFactory("redbus");//load, register, connection
            em = emf.createEntityManager();//DML, DQL
            et = em.getTransaction(); //TCL
            et.begin(); //setautocommit=0
            em.persist(signUpEntity);//DMl-Insert,Update,Delete
            et.commit();

            System.out.println("Data saved successfully in table,"+signUpEntity);
        }
        catch (PersistenceException e)
        {
            if(et!=null)
            {
                et.rollback();
            }

            e.printStackTrace();
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

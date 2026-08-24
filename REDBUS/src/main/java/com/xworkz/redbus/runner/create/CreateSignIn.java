package com.xworkz.redbus.runner.create;

import com.xworkz.redbus.entity.SignInEntity;

import javax.persistence.*;

public class CreateSignIn {

    public static void main(String[] args) {

        SignInEntity signInEntity = new SignInEntity();

        signInEntity.setEmail("Krishna@gmail.com");
        signInEntity.setPassword("krishna");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("redbus");//load, register, connection
            em=emf.createEntityManager(); //DML, DQL
            et=em.getTransaction();//TCL
            et.begin();
            em.persist(signInEntity);//Insert
            et.commit();

            System.out.println("Data saved successfully in table,"+signInEntity);
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

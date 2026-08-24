package com.xworkz.redbus.runner.read;

import com.xworkz.redbus.entity.SignInEntity;
import com.xworkz.redbus.entity.SignUpEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class ReadSignIn {
    public static void main(String[] args) {
        EntityManagerFactory emf=null;
        EntityManager em=null;

        try
        {
            emf=Persistence.createEntityManagerFactory("redbus");
            em=emf.createEntityManager();

            SignInEntity entity=em.find(SignInEntity.class,1);
            System.out.println(entity);
        }
        catch (PersistenceException e)
        {
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

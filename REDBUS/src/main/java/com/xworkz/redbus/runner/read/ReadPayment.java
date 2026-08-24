package com.xworkz.redbus.runner.read;

import com.xworkz.redbus.entity.PaymentEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class ReadPayment {
    public static void main(String[] args) {
        EntityManagerFactory emf=null;
        EntityManager em=null;

        try
        {
            emf= Persistence.createEntityManagerFactory("redbus");
            em=emf.createEntityManager();

            PaymentEntity entity=em.find(PaymentEntity.class,1);
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

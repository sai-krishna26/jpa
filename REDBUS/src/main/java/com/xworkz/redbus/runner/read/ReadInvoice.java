package com.xworkz.redbus.runner.read;

import com.xworkz.redbus.entity.InvoiceEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class ReadInvoice
{
    public static void main(String[] args) {

        EntityManagerFactory emf=null;
        EntityManager em=null;

        try
        {
            emf= Persistence.createEntityManagerFactory("redbus");
            em=emf.createEntityManager();

            InvoiceEntity entity=em.find(InvoiceEntity.class,1);
            System.out.println(entity);
        }
        catch (PersistenceException e)
        {
            e.getMessage();
        }
        finally {
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

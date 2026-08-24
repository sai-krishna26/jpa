package com.xworkz.redbus.runner.update;

import com.xworkz.redbus.entity.InvoiceEntity;

import javax.persistence.*;
import java.time.LocalDate;

public class UpdateInvoice {
    public static void main(String[] args) {

        EntityManagerFactory emf=null;
        EntityManager em=null;
        EntityTransaction et=null;

        try
        {
            emf= Persistence.createEntityManagerFactory("redbus");
            em=emf.createEntityManager();
            et=em.getTransaction();
            et.begin();

            InvoiceEntity entity=em.find(InvoiceEntity.class, 1);
            System.out.println("before update:"+entity);

            if(entity!=null)
            {
                entity.setInvoiceNumber("INV-12345");
                entity.setAmount(300.00);

                InvoiceEntity updatedEntity=em.merge(entity);
                System.out.println("after update:"+updatedEntity);
                et.commit();
            }
        }
        catch(PersistenceException e)
        {
            if(et!=null)
            {
                et.rollback();
            }
            e.printStackTrace();
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

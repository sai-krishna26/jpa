package com.xworkz.redbus.runner.create;

import com.xworkz.redbus.entity.InvoiceEntity;

import javax.persistence.*;
import java.time.LocalDate;

public class CreateInvoice {
    public static void main(String[] args) {

        InvoiceEntity invoiceEntity=new InvoiceEntity();
        invoiceEntity.setBookingId(1001);
        invoiceEntity.setInvoiceNumber("1234567890");
        invoiceEntity.setTravelDate(LocalDate.now());
        invoiceEntity.setAmount(100.0);
        invoiceEntity.setPaymentStatus(true);

        EntityManagerFactory emf=null;
        EntityManager em=null;
        EntityTransaction et=null;

        try
        {
            emf= Persistence.createEntityManagerFactory("redbus");//load, register, connection
            em=emf.createEntityManager();//DML,DQL
            et=em.getTransaction();//TCL
            et.begin();//setautocommit=0
            em.persist(invoiceEntity);//Insert
            et.commit();

            System.out.println("Data saved successfully in table,"+invoiceEntity);
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

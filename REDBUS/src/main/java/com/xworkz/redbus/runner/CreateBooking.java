package com.xworkz.redbus.runner;

import com.xworkz.redbus.entity.BookingEntity;

import javax.persistence.*;
import java.time.LocalDate;

public class CreateBooking {

    public static void main(String[] args) {

        BookingEntity bookingEntity = new BookingEntity();

        bookingEntity.setFrom("Bengalore");
        bookingEntity.setTo("Hyderabad");
        bookingEntity.setDate(LocalDate.now());
        bookingEntity.setIsForWomen(false);

        EntityManagerFactory emf=null;
        EntityManager em=null;
        EntityTransaction et=null;

        try
        {
            emf=Persistence.createEntityManagerFactory("redbus");//load, register, connection
            em=emf.createEntityManager();//DML,DQL
            et=em.getTransaction();//TCL
            et.begin();//setautocommit=0
            em.persist(bookingEntity);//Insert
            et.commit();

            System.out.println("Data saved successfully in table,"+bookingEntity);
        }
        catch (PersistenceException e)
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

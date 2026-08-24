package com.xworkz.redbus.runner.update;

import com.xworkz.redbus.entity.BookingEntity;

import javax.persistence.*;

public class UpdateBooking {
    public static void main(String[] args)
    {
        EntityManagerFactory emf=null;
        EntityManager em=null;
        EntityTransaction et=null;

        try
        {
            emf= Persistence.createEntityManagerFactory("redbus");
            em=emf.createEntityManager();
            et=em.getTransaction();
            et.begin();

            BookingEntity entity=em.find(BookingEntity.class,1);
            System.out.println("before update:"+entity);

            if(entity!=null)
            {
                entity.setFrom("Bengaluru");
                entity.setTo("Mysore");

                BookingEntity updatedEntity=em.merge(entity);
                System.out.println("after update:"+updatedEntity);
                et.commit();
            }
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

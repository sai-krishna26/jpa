package com.xworkz.redbus.runner.delete;

import com.xworkz.redbus.entity.SignUpEntity;

import javax.persistence.*;

public class DeleteSignUp {
    public static void main(String[] args) {

        EntityManagerFactory emf=null;
        EntityManager em=null;
        EntityTransaction et=null;

        try {
            emf = Persistence.createEntityManagerFactory("redbus");
            em = emf.createEntityManager();
            et = em.getTransaction();

            SignUpEntity entity = em.find(SignUpEntity.class, 1);
            System.out.println("before delete" + entity);

            if (entity != null) {
                et.begin();
                em.remove(entity);
                SignUpEntity deletedEntity = em.find(SignUpEntity.class, 1);
                System.out.println("after delete: " + deletedEntity);
                et.commit();
            }
        }
        catch (PersistenceException e)
        {
            et.rollback();
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
        {
    }
}

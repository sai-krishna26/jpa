package com.xworkz.redbus.runner.create;

import com.xworkz.redbus.entity.PaymentEntity;

import javax.persistence.*;


public class CreatePayment {
    public static void main(String[] args) {

        PaymentEntity paymentEntity=new PaymentEntity();
        paymentEntity.setPaymentMethod("upi");
        paymentEntity.setAmount(100.0);
        paymentEntity.setUpiId(12354326789L);

        EntityManagerFactory emf=null;
        EntityManager em=null;
        EntityTransaction et=null;

        try
        {
            emf=Persistence.createEntityManagerFactory("redbus");//load,register,connection
            em=emf.createEntityManager();//DML-DQL
            et=em.getTransaction();//TCL
            et.begin();//setautocommit=0
            em.persist(paymentEntity);//Insert
            et.commit();

            System.out.println("Data saved successfully in table,"+paymentEntity);
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

package com.xworkz.slice.dao.impl;

import com.xworkz.slice.dao.AccountDetailsDao;
import com.xworkz.slice.entity.AccountDetailsEntity;

import javax.persistence.*;

public class AccountDetailsDaoImpl implements AccountDetailsDao {
    @Override
    public boolean save(AccountDetailsEntity accountDetailsEntity) {
        System.out.println("Running save method in AccountDetailsDaoImpl");
        boolean isSaved =false;

        if(accountDetailsEntity!=null)
        {
//            accountDetailsEntity.setAccountNumber(accountDetailsEntity.getAccountNumber());
//            accountDetailsEntity.setAccountHolderId(accountDetailsEntity.getAccountHolderId());
//            accountDetailsEntity.setAccountHolderName(accountDetailsEntity.getAccountHolderName());
//            accountDetailsEntity.setAge(accountDetailsEntity.getAge());
//            accountDetailsEntity.setGender(accountDetailsEntity.getGender());

            EntityManagerFactory emf=null;
            EntityManager em=null;
            EntityTransaction et=null;

            try
            {
                emf= Persistence.createEntityManagerFactory("slice");
                em=emf.createEntityManager();
                et=em.getTransaction();
                et.begin();
                em.persist(accountDetailsEntity);
                et.commit();

                isSaved=true;
                System.out.println(accountDetailsEntity);
                System.out.println("Data saved successfully in accounts table");
            }
            catch (PersistenceException e)
            {
                if(et!=null)
                {
                    et.rollback();
                }
                e.printStackTrace();
                System.out.println("Failed to save data in accounts table");
            }
            finally
            {
                if (emf!=null)
                {
                    emf.close();
                }
                if (em!=null)
                {
                    em.close();
                }
            }
        }
        else
        {
            System.out.println("Failed,accountDetailsEntity is null");
        }
        return isSaved;
    }
}

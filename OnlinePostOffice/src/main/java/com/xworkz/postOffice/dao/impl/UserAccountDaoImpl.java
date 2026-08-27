package com.xworkz.postOffice.dao.impl;

import com.xworkz.postOffice.dao.UserAccountDao;
import com.xworkz.postOffice.entity.UserAccountEntity;

import javax.persistence.*;

public class UserAccountDaoImpl implements UserAccountDao {
    @Override
    public boolean save(UserAccountEntity userAccountEntity) {
        System.out.println("Running save() in UserAccountDaoImpl");
        boolean isSaved=false;

        if(userAccountEntity!=null)
        {
            EntityManagerFactory emf=null;
            EntityManager em=null;
            EntityTransaction et=null;

            try{
                emf= Persistence.createEntityManagerFactory("post_office");
                em=emf.createEntityManager();
                et=em.getTransaction();
                et.begin();
                em.persist(userAccountEntity);
                et.commit();

                isSaved=true;
                System.out.println("Data saved successfully in userAccount table");
            }
            catch (PersistenceException e)
            {
                if(et!=null)
                {
                    et.rollback();
                }
                System.out.println("Data not saved");
                e.printStackTrace();
            }
            finally {
                if(emf!=null)
                {
                    emf.close();
                }
                if(emf!=null)
                {
                    em.close();
                }
            }
        }
        else
        {
            System.out.println("Data not saved,UserAccountEntity is null");
        }
        return isSaved;
    }
}

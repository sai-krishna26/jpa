package com.xworkz.Quick.dao.impl;

import com.xworkz.Quick.dao.RegisterDao;
import com.xworkz.Quick.entity.RegisterEntity;
import com.xworkz.Quick.util.EntityManagerFactoryUtil;

import javax.crypto.spec.PSource;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

public class RegisterDaoImpl implements RegisterDao {
    @Override
    public Boolean save(RegisterEntity registerEntity) {

        System.out.println("running save method in Dao");
        Boolean isSaved=false;

        EntityManager em=null;
        EntityTransaction et=null;

        if(registerEntity!=null)
        {
            try {
                em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
                et = em.getTransaction();
                et.begin();
                em.persist(registerEntity);
                et.commit();
                isSaved = true;
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
                if(em!=null)
                {
                    em.close();
                }
            }
        }
        else {
            System.out.println("registerEntity should not be null");
        }
        return isSaved;
    }
}

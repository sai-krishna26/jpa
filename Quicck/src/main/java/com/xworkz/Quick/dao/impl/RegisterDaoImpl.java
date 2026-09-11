package com.xworkz.Quick.dao.impl;

import com.xworkz.Quick.dao.RegisterDao;
import com.xworkz.Quick.entity.RegisterEntity;
import com.xworkz.Quick.util.EntityManagerFactoryUtil;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    @Override
    public List<RegisterEntity> readAllRegisters() {
        System.out.println("running readAllRegisters method in Dao");
        EntityManagerFactory emf=null;
        EntityManager em=null;
        List<RegisterEntity> registerEntityList= new ArrayList<>();
        try{
            //return EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager().createNamedQuery("readAllRegisters").getResultList();
            emf= Persistence.createEntityManagerFactory("Quick");
            em=emf.createEntityManager();
            Query query=em.createQuery("select n from RegisterEntity n");
            registerEntityList=query.getResultList();
            return registerEntityList;
        }
        catch (PersistenceException e)
        {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
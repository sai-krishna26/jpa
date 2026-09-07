package com.xworkz.showroom.dao.impl;

import com.xworkz.showroom.dao.MotorCycleInfoDao;
import com.xworkz.showroom.dto.MotorCycleInfoDto;
import com.xworkz.showroom.entity.MotorCycleInfoEntity;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class MotorCycleInfoDaoImpl implements MotorCycleInfoDao {

    @Override
    public boolean save(MotorCycleInfoEntity motorCycleInfoEntity) {
        System.out.println("Running save() method in MotorCycleInfoDaoImpl");
        boolean isSaved=false;

        if(motorCycleInfoEntity!=null)
        {
            EntityManagerFactory emf=null;
            EntityManager em=null;
            EntityTransaction et=null;

            try
            {
                emf= Persistence.createEntityManagerFactory("BikeShowroom");
                em=emf.createEntityManager();
                et=em.getTransaction();
                et.begin();
                em.persist(motorCycleInfoEntity);
                et.commit();
                isSaved=true;

                System.out.println("Data saved successfully in motorcycle_info table");
            }
            catch (PersistenceException e)
            {
                if(et!=null)
                {
                    et.rollback();
                }
                System.out.println("data not saved,exception occurred");
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
        else
        {
            System.out.println("Data not saved, motorCycleInfoEntity is null");
        }
        return isSaved;
    }

    @Override
    public boolean saveAll(List<MotorCycleInfoEntity> entities) {
        System.out.println("Running saveAll() method in MotorCycleInfoDaoImpl");
        boolean isSaved = false;

        if (entities != null && !entities.isEmpty()) {
            EntityManagerFactory emf = null;
            EntityManager em = null;
            EntityTransaction et = null;

            try {
                emf = Persistence.createEntityManagerFactory("BikeShowroom");
                em = emf.createEntityManager();
                et = em.getTransaction();
                et.begin();

                for (MotorCycleInfoEntity entity : entities) {
                    if (entity != null) {
                        em.persist(entity);
                    }
                }

                et.commit();
                isSaved = true;
                System.out.println("All data saved successfully in motorcycle_info table");
            } catch (PersistenceException e) {
                if (et != null) {
                    et.rollback();
                    isSaved=false;
                }
                System.out.println("Data not saved");
                e.printStackTrace();
            } finally {
                if (emf != null) {
                    emf.close();
                }
                if (em != null) {
                    em.close();
                }
            }
        } else {
            System.out.println("Data not saved, entities list is null");
        }
        return isSaved;
    }

    @Override
    public MotorCycleInfoEntity getMotorCycleEntity(Integer id) {
        System.out.println("Running getMotorCycleEntity method in MotorCycleInfoDaoImpl");

        MotorCycleInfoEntity entity=null;
        EntityManagerFactory emf=null;
        EntityManager em=null;
        try
        {
            emf=Persistence.createEntityManagerFactory("BikeShowroom");
            em=emf.createEntityManager();
            entity=em.find(MotorCycleInfoEntity.class, id);
        }
        catch (PersistenceException e)
        {
            System.out.println("Data not found");
            e.printStackTrace();
            entity=null;
        }
        finally
        {
            if(em != null)
            {
                em.close();
            }
            if(emf != null)
            {
                emf.close();
            }
        }
        return entity;
    }

    @Override
    public List<MotorCycleInfoEntity> readAllMotorCycleInfo()
    {
        System.out.println("Running readAllMotorCycleInfo() method in MotorCycleInfoDaoImpl");
        EntityManagerFactory emf=null;
        EntityManager em=null;
        List<MotorCycleInfoEntity> motorCycleInfoEntityList= Collections.emptyList();

        try
        {
            emf=Persistence.createEntityManagerFactory("BikeShowroom");
            em=emf.createEntityManager();
            Query query=em.createQuery("select n from MotorCycleInfoEntity n");
            motorCycleInfoEntityList=query.getResultList();
        }
        catch (PersistenceException e)
        {
                e.printStackTrace();
        }
        finally
        {
            if(em!=null)
            {
                em.close();
            }
            if(emf!=null)
            {
                emf.close();
            }
        }

        return motorCycleInfoEntityList;
    }

    @Override
    public List<MotorCycleInfoEntity> getMotorCycleByNameAndEngineType(String name,String engineType) {
        System.out.println("Running getMotorCycleByNameAndEngineType(name,etype) in MotorCycleInfoDaoImpl");
        EntityManagerFactory emf=null;
        EntityManager em=null;
        List<MotorCycleInfoEntity> entityList=null;

        try
        {
            emf=Persistence.createEntityManagerFactory("BikeShowroom");
            em=emf.createEntityManager();
            Query query=em.createNamedQuery("getMotorCycleByNameAndEngineType");
            query.setParameter("name",name);
            query.setParameter("engineType",engineType);

            entityList=query.getResultList();

        }
        catch (PersistenceException e)
        {
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
        return entityList;
    }
}

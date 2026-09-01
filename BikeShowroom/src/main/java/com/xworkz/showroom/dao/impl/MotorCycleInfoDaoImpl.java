package com.xworkz.showroom.dao.impl;

import com.xworkz.showroom.dao.MotorCycleInfoDao;
import com.xworkz.showroom.entity.MotorCycleInfoEntity;

import javax.persistence.*;
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
    public boolean getMotorCycleEntity(Integer id) {
        System.out.println("Running getMotorCycleEntity method in MotorCycleInfoDaoImpl");

        MotorCycleInfoEntity entity=null;
        EntityManagerFactory emf=null;
        EntityManager em=null;
        boolean isFound=false;
        try
        {
            emf=Persistence.createEntityManagerFactory("krishna");
            em=emf.createEntityManager();
            entity=em.find(MotorCycleInfoEntity.class, id);
            if(entity!=null)
            {
                isFound=true;
            }
            else
            {
                isFound=false;
            }
        }
        catch (PersistenceException e)
        {
            System.out.println("Data not found");
            e.printStackTrace();
            entity=null;
            isFound=false;
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
        return isFound;
    }
}

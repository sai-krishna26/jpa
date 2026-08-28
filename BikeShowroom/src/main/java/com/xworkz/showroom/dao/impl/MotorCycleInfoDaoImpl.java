package com.xworkz.showroom.dao.impl;

import com.xworkz.showroom.dao.MotorCycleInfoDao;
import com.xworkz.showroom.entity.MotorCycleInfoEntity;

import javax.persistence.*;

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
                System.out.println("data not saved");
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

}

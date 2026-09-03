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

//    @Override
//    public List<MotorCycleInfoEntity> readAllMotorCycleEntity() {
//        System.out.println("Running readAllMotorCycleEntity method in MotorCycleInfoDaoImpl");
//        List<MotorCycleInfoEntity> entities = null;
//        EntityManagerFactory emf = null;
//        EntityManager em = null;
//        try {
//            emf = Persistence.createEntityManagerFactory("BikeShowroom");
//            em = emf.createEntityManager();
//            entities = em.createNamedQuery("getAllMotorCycles", MotorCycleInfoEntity.class).getResultList();
//        } catch (PersistenceException e) {
//            System.out.println("Data not found");
//            e.printStackTrace();
//            entities = null;
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//            if (emf != null) {
//                emf.close();
//            }
//        }
//        return entities;
//    }
//
//    @Override
//    public List<MotorCycleInfoEntity> getMotorCyclesByNameAndEngineType(String name, String engineType) {
//        System.out.println("Running getMotorCyclesByNameAndEngineType method in MotorCycleInfoDaoImpl");
//        List<MotorCycleInfoEntity> entities = null;
//        EntityManagerFactory emf = null;
//        EntityManager em = null;
//        try {
//            emf = Persistence.createEntityManagerFactory("BikeShowroom");
//            em = emf.createEntityManager();
//            entities = em.createNamedQuery("getMotorCyclesByNameAndEngineType", MotorCycleInfoEntity.class)
//                    .setParameter("name", name)
//                    .setParameter("engineType", engineType)
//                    .getResultList();
//        } catch (PersistenceException e) {
//            System.out.println("Data not found");
//            e.printStackTrace();
//            entities = null;
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//            if (emf != null) {
//                emf.close();
//            }
//        }
//        return entities;
//    }
//
//    @Override
//    public List<MotorCycleInfoEntity> getMotorCyclesByEngineTypeAndPrice(String engineType, Double price) {
//        System.out.println("Running getMotorCyclesByEngineTypeAndPrice method in MotorCycleInfoDaoImpl");
//        List<MotorCycleInfoEntity> entities = null;
//        EntityManagerFactory emf = null;
//        EntityManager em = null;
//        try {
//            emf = Persistence.createEntityManagerFactory("BikeShowroom");
//            em = emf.createEntityManager();
//            entities = em.createNamedQuery("getMotorCyclesByEngineTypeAndPrice", MotorCycleInfoEntity.class)
//                    .setParameter("engineType", engineType)
//                    .setParameter("price", price)
//                    .getResultList();
//        } catch (PersistenceException e) {
//            System.out.println("Data not found");
//            e.printStackTrace();
//            entities = null;
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//            if (emf != null) {
//                emf.close();
//            }
//        }
//        return entities;
//    }
//
//    @Override
//    public MotorCycleInfoEntity getMotorCycleByNameAndEngineType(String name, String engineType) {
//        System.out.println("Running getMotorCycleByNameAndEngineType method in MotorCycleInfoDaoImpl");
//        MotorCycleInfoEntity entity = null;
//        EntityManagerFactory emf = null;
//        EntityManager em = null;
//        try {
//            emf = Persistence.createEntityManagerFactory("BikeShowroom");
//            em = emf.createEntityManager();
//            entity = em.createNamedQuery("getMotorCycleByNameAndEngineType", MotorCycleInfoEntity.class)
//                    .setParameter("name", name)
//                    .setParameter("engineType", engineType)
//                    .getSingleResult();
//        } catch (PersistenceException e) {
//            System.out.println("Data not found");
//            e.printStackTrace();
//            entity = null;
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//            if (emf != null) {
//                emf.close();
//            }
//        }
//        return entity;
//    }
//
//    @Override
//    public Boolean updatePriceByName(String name, Double price) {
//        System.out.println("Running updatePriceByName method in MotorCycleInfoDaoImpl");
//        Boolean isUpdated = false;
//        EntityManagerFactory emf = null;
//        EntityManager em = null;
//        EntityTransaction et = null;
//        try {
//            emf = Persistence.createEntityManagerFactory("BikeShowroom");
//            em = emf.createEntityManager();
//            et = em.getTransaction();
//            et.begin();
//            int rowsAffected = em.createNamedQuery("updatePriceByName")
//                    .setParameter("price", price)
//                    .setParameter("name", name)
//                    .executeUpdate();
//            et.commit();
//            isUpdated = rowsAffected > 0;
//            System.out.println("Price updated successfully");
//        } catch (PersistenceException e) {
//            if (et != null) {
//                et.rollback();
//            }
//            System.out.println("Price not updated");
//            e.printStackTrace();
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//            if (emf != null) {
//                emf.close();
//            }
//        }
//        return isUpdated;
//    }
//
//    @Override
//    public Boolean updateQuantityByName(String name, Integer quantity) {
//        System.out.println("Running updateQuantityByName method in MotorCycleInfoDaoImpl");
//        Boolean isUpdated = false;
//        EntityManagerFactory emf = null;
//        EntityManager em = null;
//        EntityTransaction et = null;
//        try {
//            emf = Persistence.createEntityManagerFactory("BikeShowroom");
//            em = emf.createEntityManager();
//            et = em.getTransaction();
//            et.begin();
//            int rowsAffected = em.createNamedQuery("updateQuantityByName")
//                    .setParameter("quantity", quantity)
//                    .setParameter("name", name)
//                    .executeUpdate();
//            et.commit();
//            isUpdated = rowsAffected > 0;
//            System.out.println("Quantity updated successfully");
//        } catch (PersistenceException e) {
//            if (et != null) {
//                et.rollback();
//            }
//            System.out.println("Quantity not updated");
//            e.printStackTrace();
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//            if (emf != null) {
//                emf.close();
//            }
//        }
//        return isUpdated;
//    }
}

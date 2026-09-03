package com.xworkz.showroom.dao;

import com.xworkz.showroom.entity.MotorCycleInfoEntity;
import java.util.List;

public interface MotorCycleInfoDao {
    public boolean save(MotorCycleInfoEntity motorCycleInfoEntity);
    public boolean saveAll(List<MotorCycleInfoEntity> entities);
    public MotorCycleInfoEntity getMotorCycleEntity(Integer id);
//    public List<MotorCycleInfoEntity> readAllMotorCycleEntity();
//    public List<MotorCycleInfoEntity> getMotorCyclesByNameAndEngineType(String name, String engineType);
//    public List<MotorCycleInfoEntity> getMotorCyclesByEngineTypeAndPrice(String engineType, Double price);
//    public MotorCycleInfoEntity getMotorCycleByNameAndEngineType(String name, String engineType);
//    public Boolean updatePriceByName(String name, Double price);
//    public Boolean updateQuantityByName(String name, Integer quantity);
}

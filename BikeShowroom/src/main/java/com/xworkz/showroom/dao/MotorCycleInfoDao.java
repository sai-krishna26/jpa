package com.xworkz.showroom.dao;

import com.xworkz.showroom.entity.MotorCycleInfoEntity;
import java.util.List;

public interface MotorCycleInfoDao {
    public boolean save(MotorCycleInfoEntity motorCycleInfoEntity);
    public boolean saveAll(List<MotorCycleInfoEntity> entities);
    public MotorCycleInfoEntity getMotorCycleEntity(Integer id);

    public List<MotorCycleInfoEntity> readAllMotorCycleInfo();
    public List<MotorCycleInfoEntity> getMotorCycleByNameAndEngineType(String name,String engineType);
    public List<MotorCycleInfoEntity> getMotorCycleByMileage(String mileage);

    public Boolean updateNameById(String name, Integer id);
    public Boolean updateNameAndPriceByMileage(String name,Double price,Integer mileage);
}

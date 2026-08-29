package com.xworkz.showroom.dao;

import com.xworkz.showroom.entity.MotorCycleInfoEntity;
import java.util.List;

public interface MotorCycleInfoDao {
    public boolean save(MotorCycleInfoEntity motorCycleInfoEntity);
    public boolean saveAll(List<MotorCycleInfoEntity> entities);
}

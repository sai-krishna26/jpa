package com.xworkz.showroom.service.impl;

import com.xworkz.showroom.dao.MotorCycleInfoDao;
import com.xworkz.showroom.dao.impl.MotorCycleInfoDaoImpl;
import com.xworkz.showroom.dto.MotorCycleInfoDto;
import com.xworkz.showroom.entity.MotorCycleInfoEntity;
import com.xworkz.showroom.service.MotorCycleInfoService;

public class MotorCycleInfoServiceImpl implements MotorCycleInfoService {

    @Override
    public boolean save(MotorCycleInfoDto motorCycleInfoDto) {
        System.out.println("Running save() method in MotorCycleInfoServiceImpl");
        boolean isSaved=false;

        if(motorCycleInfoDto!=null)
        {
            MotorCycleInfoEntity motorCycleInfoEntity=new MotorCycleInfoEntity();

            motorCycleInfoEntity.setName(motorCycleInfoDto.getName());
            motorCycleInfoEntity.setEngine_type(motorCycleInfoDto.getEngine_type());
            motorCycleInfoEntity.setMileage(motorCycleInfoDto.getMileage());
            motorCycleInfoEntity.setPrice(motorCycleInfoDto.getPrice());

            MotorCycleInfoDao motorCycleInfoDao=new MotorCycleInfoDaoImpl();
            boolean result= motorCycleInfoDao.save(motorCycleInfoEntity);
            isSaved=true;

            if(result)
            {
                System.out.println("Data saved successfully inside MotorCycleInfoDaoImpl");
            }
            else
            {
                System.out.println("Data not saved inside MotorCycleInfoDaoImpl");
            }
        }
        else
        {
            System.out.println("Data not saved, motorCycleInfoDto is null");
        }

        return isSaved;
    }
}

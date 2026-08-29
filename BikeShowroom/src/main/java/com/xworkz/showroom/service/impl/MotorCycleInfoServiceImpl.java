package com.xworkz.showroom.service.impl;

import com.xworkz.showroom.dao.MotorCycleInfoDao;
import com.xworkz.showroom.dao.impl.MotorCycleInfoDaoImpl;
import com.xworkz.showroom.dto.MotorCycleInfoDto;
import com.xworkz.showroom.entity.MotorCycleInfoEntity;
import com.xworkz.showroom.service.MotorCycleInfoService;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public boolean saveAll(List<MotorCycleInfoDto> dtos) {
        System.out.println("Running saveAll() method in MotorCycleInfoServiceImpl");
        boolean isSaved = false;

        if (dtos != null && !dtos.isEmpty()) {
            List<MotorCycleInfoEntity> entities = dtos.stream()
                    .filter(dto -> dto != null)
                    .map(dto -> {
                        MotorCycleInfoEntity entity = new MotorCycleInfoEntity();
                        entity.setName(dto.getName());
                        entity.setEngine_type(dto.getEngine_type());
                        entity.setMileage(dto.getMileage());
                        entity.setPrice(dto.getPrice());
                        return entity;
                    })
                    .collect(Collectors.toList());

            MotorCycleInfoDao motorCycleInfoDao = new MotorCycleInfoDaoImpl();
            boolean result = motorCycleInfoDao.saveAll(entities);
            isSaved = true;

            if (result) {
                System.out.println("All data saved successfully inside MotorCycleInfoDaoImpl");
            } else {
                System.out.println("Data not saved inside MotorCycleInfoDaoImpl");
            }
        } else {
            System.out.println("Data not saved, dtos list is null or empty");
        }

        return isSaved;
    }
}

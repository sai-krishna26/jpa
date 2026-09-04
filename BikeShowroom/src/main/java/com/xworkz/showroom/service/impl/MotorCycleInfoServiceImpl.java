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
    public boolean validateAndSave(MotorCycleInfoDto motorCycleInfoDto) {
        System.out.println("Running ValidateAndSave() method in MotorCycleInfoServiceImpl");
        boolean isSaved=false;

        if(motorCycleInfoDto!=null)
        {
            MotorCycleInfoEntity motorCycleInfoEntity=new MotorCycleInfoEntity();

            motorCycleInfoEntity.setName(motorCycleInfoDto.getName());
            motorCycleInfoEntity.setEngine_type(motorCycleInfoDto.getEngineType());
            motorCycleInfoEntity.setMileage(motorCycleInfoDto.getMileage());
            motorCycleInfoEntity.setPrice(motorCycleInfoDto.getPrice());
            motorCycleInfoEntity.setQuantity(motorCycleInfoDto.getQuantity());

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
    public boolean validateAndSaveAll(List<MotorCycleInfoDto> dtos) {
        System.out.println("Running ValidateAndSaveAll() method in MotorCycleInfoServiceImpl");
        boolean isSaved = false;

        if (dtos != null && !dtos.isEmpty()) {
            List<MotorCycleInfoEntity> entities = dtos.stream()
                    .filter(dto -> dto != null)
                    .map(dto -> {
                        MotorCycleInfoEntity entity = new MotorCycleInfoEntity();
                        entity.setName(dto.getName());
                        entity.setEngine_type(dto.getEngineType());
                        entity.setMileage(dto.getMileage());
                        entity.setPrice(dto.getPrice());
                        entity.setQuantity(dto.getQuantity());
                        return entity;
                    })
                    .collect(Collectors.toList());

            MotorCycleInfoDao motorCycleInfoDao = new MotorCycleInfoDaoImpl();
            boolean result = motorCycleInfoDao.saveAll(entities);

            if (result) {
                isSaved = true;
                System.out.println("All data saved successfully inside MotorCycleInfoDaoImpl");
            } else {
                System.out.println("Data not saved inside MotorCycleInfoDaoImpl");
            }
        } else {
            System.out.println("Data not saved, dtos list is null or empty");
        }

        return isSaved;
    }

    @Override
    public MotorCycleInfoDto validateAndFindById(Integer id) {
        System.out.println("Running ValidateAndFindById() method in MotorCycleInfoServiceImpl");

        MotorCycleInfoDto dto=null;

        MotorCycleInfoDao motorCycleInfoDao=new MotorCycleInfoDaoImpl();
        MotorCycleInfoEntity motorCycleInfoEntity=motorCycleInfoDao.getMotorCycleEntity(id);

        if(motorCycleInfoEntity!=null)
        {
            dto=new MotorCycleInfoDto(motorCycleInfoEntity.getName(), motorCycleInfoEntity.getEngine_type(), motorCycleInfoEntity.getMileage(), motorCycleInfoEntity.getPrice(), motorCycleInfoEntity.getQuantity());
        }
        else
        {
            System.out.println("Data not found inside MotorCycleInfoDaoImpl");
        }
        return dto;
    }


}

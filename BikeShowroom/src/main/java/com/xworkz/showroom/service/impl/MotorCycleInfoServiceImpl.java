package com.xworkz.showroom.service.impl;

import com.xworkz.showroom.dao.MotorCycleInfoDao;
import com.xworkz.showroom.dao.impl.MotorCycleInfoDaoImpl;
import com.xworkz.showroom.dto.MotorCycleInfoDto;
import com.xworkz.showroom.entity.MotorCycleInfoEntity;
import com.xworkz.showroom.service.MotorCycleInfoService;
import org.hibernate.hql.spi.id.local.LocalTemporaryTableBulkIdStrategy;

import java.util.ArrayList;
import java.util.Collections;
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
            motorCycleInfoEntity.setEngineType(motorCycleInfoDto.getEngineType());
            motorCycleInfoEntity.setMileage(motorCycleInfoDto.getMileage());
            motorCycleInfoEntity.setPrice(motorCycleInfoDto.getPrice());
            motorCycleInfoEntity.setQuantity(motorCycleInfoDto.getQuantity());

            MotorCycleInfoDao motorCycleInfoDao=new MotorCycleInfoDaoImpl();
            boolean result= motorCycleInfoDao.save(motorCycleInfoEntity);
            isSaved=result;

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
                        entity.setEngineType(dto.getEngineType());
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
            dto=new MotorCycleInfoDto(motorCycleInfoEntity.getName(), motorCycleInfoEntity.getEngineType(), motorCycleInfoEntity.getMileage(), motorCycleInfoEntity.getPrice(),motorCycleInfoEntity.getQuantity());
        }
        else
        {
            System.out.println("Data is not found inside MotorCycleInfoDaoImpl");
        }
        return dto;
    }

    @Override
    public List<MotorCycleInfoDto> validateAndReadAllMotorCycleInfo()
    {
        System.out.println("Running ValidateAndReadAllMotorCycleInfo() method in MotorCycleInfoServiceImpl");
        MotorCycleInfoDao motorCycleInfoDao=new MotorCycleInfoDaoImpl();
        List<MotorCycleInfoEntity> motorCycleInfoEntityList=motorCycleInfoDao.readAllMotorCycleInfo();

        List<MotorCycleInfoDto> motorCycleInfoDtoList=motorCycleInfoEntityList.stream()
                .map(entity -> {
                    MotorCycleInfoDto motorCycleInfoDto = new MotorCycleInfoDto();
                    motorCycleInfoDto.setName(entity.getName());
                    motorCycleInfoDto.setEngineType(entity.getEngineType());
                    motorCycleInfoDto.setMileage(entity.getMileage());
                    motorCycleInfoDto.setPrice(entity.getPrice());
                    motorCycleInfoDto.setQuantity(entity.getQuantity());

                    return motorCycleInfoDto;
                }).collect(Collectors.toList());
        return motorCycleInfoDtoList;
    }

    @Override
    public List<MotorCycleInfoDto> validateAndGetMotorCycleByNameAndEngineType(String name, String engineType) {
        System.out.println("Running validateAndGetMotorCycleByNameAndEngineType() in MotorCycleInfoServiceImpl");
        MotorCycleInfoDao motorCycleInfoDao=new MotorCycleInfoDaoImpl();
        List<MotorCycleInfoDto> motorCycleInfoDtoList=new ArrayList<>();
        List<MotorCycleInfoEntity> motorCycleInfoEntityList=motorCycleInfoDao.getMotorCycleByNameAndEngineType(name,engineType);

        for(MotorCycleInfoEntity entity:motorCycleInfoEntityList)
        {
            MotorCycleInfoDto motorCycleInfoDto=new MotorCycleInfoDto();

            motorCycleInfoDto.setName(entity.getName());
            motorCycleInfoDto.setEngineType(entity.getEngineType());
            motorCycleInfoDto.setMileage(entity.getMileage());
            motorCycleInfoDto.setPrice(entity.getPrice());
            motorCycleInfoDto.setQuantity(entity.getQuantity());

            motorCycleInfoDtoList.add(motorCycleInfoDto);
        }

        return motorCycleInfoDtoList;
    }

    @Override
    public List<MotorCycleInfoDto> validateAndGetByMileage(String mileage) {
        System.out.println("Running validateAndGetByMileage() in MotorCycleInfoServiceImpl");
        MotorCycleInfoDao motorCycleInfoDao=new MotorCycleInfoDaoImpl();
        List<MotorCycleInfoDto> dtoList=new ArrayList<>();
        List<MotorCycleInfoEntity> entityList=motorCycleInfoDao.getMotorCycleByMileage(mileage);

        for(MotorCycleInfoEntity entity:entityList)
        {
            MotorCycleInfoDto motorCycleInfoDto=new MotorCycleInfoDto();
            motorCycleInfoDto.setName(entity.getName());
            motorCycleInfoDto.setEngineType(entity.getEngineType());
            motorCycleInfoDto.setMileage(entity.getMileage());
            motorCycleInfoDto.setPrice(entity.getPrice());
            motorCycleInfoDto.setQuantity(entity.getQuantity());

            dtoList.add(motorCycleInfoDto);
        }
        return dtoList;
    }

    
}


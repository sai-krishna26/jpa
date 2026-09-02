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

    @Override
    public List<MotorCycleInfoDto> readAllMotorCycleDto() {
        System.out.println("Running readAllMotorCycleDto() method in MotorCycleInfoServiceImpl");
        MotorCycleInfoDao motorCycleInfoDao = new MotorCycleInfoDaoImpl();
        List<MotorCycleInfoEntity> entities = motorCycleInfoDao.readAllMotorCycleEntity();
        return entities.stream()
                .map(entity -> new MotorCycleInfoDto(entity.getName(), entity.getEngine_type(), entity.getMileage(), entity.getPrice(), entity.getQuantity()))
                .collect(Collectors.toList());
    }

    @Override
    public List<MotorCycleInfoDto> getMotorCyclesByNameAndEngineType(String name, String engineType) {
        System.out.println("Running getMotorCyclesByNameAndEngineType() method in MotorCycleInfoServiceImpl");
        MotorCycleInfoDao motorCycleInfoDao = new MotorCycleInfoDaoImpl();
        List<MotorCycleInfoEntity> entities = motorCycleInfoDao.getMotorCyclesByNameAndEngineType(name, engineType);
        return entities.stream()
                .map(entity -> new MotorCycleInfoDto(entity.getName(), entity.getEngine_type(), entity.getMileage(), entity.getPrice(), entity.getQuantity()))
                .collect(Collectors.toList());
    }

    @Override
    public List<MotorCycleInfoDto> getMotorCyclesByEngineTypeAndPrice(String engineType, Double price) {
        System.out.println("Running getMotorCyclesByEngineTypeAndPrice() method in MotorCycleInfoServiceImpl");
        MotorCycleInfoDao motorCycleInfoDao = new MotorCycleInfoDaoImpl();
        List<MotorCycleInfoEntity> entities = motorCycleInfoDao.getMotorCyclesByEngineTypeAndPrice(engineType, price);
        return entities.stream()
                .map(entity -> new MotorCycleInfoDto(entity.getName(), entity.getEngine_type(), entity.getMileage(), entity.getPrice(), entity.getQuantity()))
                .collect(Collectors.toList());
    }

    @Override
    public MotorCycleInfoDto getMotorCycleByNameAndEngineType(String name, String engineType) {
        System.out.println("Running getMotorCycleByNameAndEngineType() method in MotorCycleInfoServiceImpl");
        MotorCycleInfoDto dto = null;
        MotorCycleInfoDao motorCycleInfoDao = new MotorCycleInfoDaoImpl();
        MotorCycleInfoEntity entity = motorCycleInfoDao.getMotorCycleByNameAndEngineType(name, engineType);
        if (entity != null) {
            dto = new MotorCycleInfoDto(entity.getName(), entity.getEngine_type(), entity.getMileage(), entity.getPrice(), entity.getQuantity());
        } else {
            System.out.println("Data not found inside MotorCycleInfoDaoImpl");
        }
        return dto;
    }

    @Override
    public String updatePriceByName(String name, Double price) {
        System.out.println("Running updatePriceByName() method in MotorCycleInfoServiceImpl");
        MotorCycleInfoDao motorCycleInfoDao = new MotorCycleInfoDaoImpl();
        Boolean isUpdated = motorCycleInfoDao.updatePriceByName(name, price);
        return isUpdated ? "Price updated successfully" : "Price not updated";
    }

    @Override
    public String updateQuantityByName(String name, Integer quantity) {
        System.out.println("Running updateQuantityByName() method in MotorCycleInfoServiceImpl");
        MotorCycleInfoDao motorCycleInfoDao = new MotorCycleInfoDaoImpl();
        Boolean isUpdated = motorCycleInfoDao.updateQuantityByName(name, quantity);
        return isUpdated ? "Quantity updated successfully" : "Quantity not updated";
    }
}

package com.xworkz.showroom.service;

import com.xworkz.showroom.dto.MotorCycleInfoDto;
import java.util.List;

public interface MotorCycleInfoService {
    public boolean validateAndSave(MotorCycleInfoDto motorCycleInfoDto);
    public boolean validateAndSaveAll(List<MotorCycleInfoDto> dtos);
    public MotorCycleInfoDto validateAndFindById(Integer id);
//    public List<MotorCycleInfoDto> readAllMotorCycleDto();
//    public List<MotorCycleInfoDto> getMotorCyclesByNameAndEngineType(String name, String engineType);
//    public List<MotorCycleInfoDto> getMotorCyclesByEngineTypeAndPrice(String engineType, Double price);
//    public MotorCycleInfoDto getMotorCycleByNameAndEngineType(String name, String engineType);
//    public String updatePriceByName(String name, Double price);
//    public String updateQuantityByName(String name, Integer quantity);
}

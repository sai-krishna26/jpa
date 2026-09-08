package com.xworkz.showroom.service;

import com.xworkz.showroom.dto.MotorCycleInfoDto;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface MotorCycleInfoService {
    public boolean validateAndSave(MotorCycleInfoDto motorCycleInfoDto);
    public boolean validateAndSaveAll(List<MotorCycleInfoDto> dtos);
    public MotorCycleInfoDto validateAndFindById(Integer id);

    public List<MotorCycleInfoDto> validateAndReadAllMotorCycleInfo();

    public List<MotorCycleInfoDto> validateAndGetMotorCycleByNameAndEngineType(String name, String engineType);
    public List<MotorCycleInfoDto> validateAndGetByMileage(String mileage);

    public String validateAndUpdateNameById(String name, Integer id);
    public String validateAndUpdateNameAndPriceByMileage(String name,Double price,Integer mileage);
}

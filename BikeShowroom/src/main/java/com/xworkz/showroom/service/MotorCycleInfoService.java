package com.xworkz.showroom.service;

import com.xworkz.showroom.dto.MotorCycleInfoDto;
import java.util.List;

public interface MotorCycleInfoService {
    public boolean validateAndSave(MotorCycleInfoDto motorCycleInfoDto);
    public boolean validateAndSaveAll(List<MotorCycleInfoDto> dtos);
    public MotorCycleInfoDto validateAndFindById(Integer id);
}

package com.xworkz.showroom.service;

import com.xworkz.showroom.dto.MotorCycleInfoDto;
import java.util.List;

public interface MotorCycleInfoService {
    public boolean save(MotorCycleInfoDto motorCycleInfoDto);
    public boolean saveAll(List<MotorCycleInfoDto> dtos);
}

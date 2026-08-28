package com.xworkz.showroom;

import com.xworkz.showroom.dto.MotorCycleInfoDto;
import com.xworkz.showroom.service.MotorCycleInfoService;
import com.xworkz.showroom.service.impl.MotorCycleInfoServiceImpl;

public class runner {
    public static void main(String[] args)
    {
        System.out.println("Bike Showroom");

        MotorCycleInfoDto motorCycleInfoDto = new MotorCycleInfoDto();

        motorCycleInfoDto.setName("Yamaha");
        motorCycleInfoDto.setEngine_type("Petrol");
        motorCycleInfoDto.setMileage("50");
        motorCycleInfoDto.setPrice(1000000);

        MotorCycleInfoService motorCycleInfoService = new MotorCycleInfoServiceImpl();
        motorCycleInfoService.save(motorCycleInfoDto);
    }
}

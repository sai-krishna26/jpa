package com.xworkz.showroom;

import com.xworkz.showroom.dto.MotorCycleInfoDto;
import com.xworkz.showroom.service.MotorCycleInfoService;
import com.xworkz.showroom.service.impl.MotorCycleInfoServiceImpl;

import java.util.Arrays;
import java.util.List;

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

        System.out.println("\n--- Batch Insert ---");

        List<MotorCycleInfoDto> dtos = Arrays.asList(
                new MotorCycleInfoDto("Honda", "Petrol", "45", 850000),
                new MotorCycleInfoDto("Royal Enfield", "Petrol", "35", 1500000),
                new MotorCycleInfoDto("Bajaj", "Petrol", "55", 750000),
                new MotorCycleInfoDto("KTM", "Petrol", "40", 1800000),
                new MotorCycleInfoDto("Suzuki", "Petrol", "48", 950000)
        );

        boolean result = motorCycleInfoService.saveAll(dtos);
        System.out.println("Batch insert result: " + result);
    }
}

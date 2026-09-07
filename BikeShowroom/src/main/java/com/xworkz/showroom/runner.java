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

//        MotorCycleInfoDto motorCycleInfoDto = new MotorCycleInfoDto();
//
//        motorCycleInfoDto.setName("Yamaha");
//        motorCycleInfoDto.setEngineType("Petrol");
//        motorCycleInfoDto.setMileage("50");
//        motorCycleInfoDto.setPrice(100000.0);
//        motorCycleInfoDto.setQuantity(1);
//
//        MotorCycleInfoService motorCycleInfoService = new MotorCycleInfoServiceImpl();
//        motorCycleInfoService.validateAndSave(motorCycleInfoDto);
//
//        System.out.println("\n--- Batch Insert ---");
//
//        List<MotorCycleInfoDto> dtos = Arrays.asList(
//                new MotorCycleInfoDto("Honda", "Petrol", "45", 850000.0,2),
//                new MotorCycleInfoDto("Royal Enfield", "Petrol", "35", 150000.0,2),
//                new MotorCycleInfoDto("Bajaj", "Petrol", "55", 750000.0,1),
//                new MotorCycleInfoDto("KTM", "Petrol", "40", 180000.0,1),
//                new MotorCycleInfoDto("Suzuki", "Petrol", "48", 950000.0,1)
//        );
//
//        boolean result = motorCycleInfoService.validateAndSaveAll(dtos);
//        System.out.println("Batch insert result: " + result);
//
//        System.out.println("\n--- Find by ID ---");
//        MotorCycleInfoService motorCycleInfoService1=new MotorCycleInfoServiceImpl();
//        MotorCycleInfoDto motorCycleInfoDto1=motorCycleInfoService1.validateAndFindById(1);
//        System.out.println("result:"+motorCycleInfoDto1);
//
//        System.out.println("\n----Read All----");
//        MotorCycleInfoService motorCycleInfoService2=new MotorCycleInfoServiceImpl();
//        List<MotorCycleInfoDto> motorCycleInfoDto2=motorCycleInfoService2.validateAndReadAllMotorCycleInfo();
//        System.out.println("result:"+motorCycleInfoDto2);

        System.out.println("\n----Find by name and engineType----");
        MotorCycleInfoService motorCycleInfoService3=new MotorCycleInfoServiceImpl();
        List<MotorCycleInfoDto> motorCycleInfoDto3=motorCycleInfoService3.validateAndGetMotorCycleByNameAndEngineType("Yamaha","Petrol");
        System.out.println("result:"+motorCycleInfoDto3);
    }
}

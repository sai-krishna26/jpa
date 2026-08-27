package com.xworkz.rapido;

import com.xworkz.rapido.dto.RideInfoDto;
import com.xworkz.rapido.entity.RideInfoEntity;
import com.xworkz.rapido.server.RiderInfoService;
import com.xworkz.rapido.server.impl.RiderInfoServiceImpl;

public class runner {
    public static void main(String[] args)
    {
        System.out.println("Rapido RoadSter");

        RideInfoDto rideInfoDto=new RideInfoDto();

        rideInfoDto.setFrom("BTM Layout");
        rideInfoDto.setTo("Chikkapete");
        rideInfoDto.setPaymentMode("UPI");
        rideInfoDto.setCustomerName("Ravikumar");
        rideInfoDto.setCost(100.0);

        RiderInfoService riderInfoService=new RiderInfoServiceImpl();

    }
}

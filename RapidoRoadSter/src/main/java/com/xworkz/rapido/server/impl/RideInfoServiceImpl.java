package com.xworkz.rapido.server.impl;

import com.xworkz.rapido.dao.RideInfoDao;
import com.xworkz.rapido.dao.impl.RideInfoDaoImpl;
import com.xworkz.rapido.dto.RideInfoDto;
import com.xworkz.rapido.entity.RideInfoEntity;
import com.xworkz.rapido.server.RideInfoService;

public class RideInfoServiceImpl implements RideInfoService {

    @Override
    public boolean save(RideInfoDto rideInfoDto) {

        System.out.println("Running save() in RideInfoServiceImpl");
        boolean isSaved=false;

        if(rideInfoDto!=null)
        {
            RideInfoEntity rideInfoEntity=new RideInfoEntity();

            rideInfoEntity.setFrom(rideInfoDto.getFrom());
            rideInfoEntity.setTo(rideInfoDto.getTo());
            rideInfoEntity.setPaymentMode(rideInfoDto.getPaymentMode());
            rideInfoEntity.setCustomerName(rideInfoDto.getCustomerName());
            rideInfoEntity.setCost(rideInfoEntity.getCost());

            RideInfoDao rideInfoDao= new RideInfoDaoImpl();
            boolean result=rideInfoDao.save(rideInfoEntity);

            if(result)
            {
                isSaved=true;
                System.out.println("Data saved successfully in RideInfoDaoImpl");
            }
            else
            {
                System.out.println("Failed to save data in RideInfoDaoImpl");
            }
        }
        return isSaved;
    }
}

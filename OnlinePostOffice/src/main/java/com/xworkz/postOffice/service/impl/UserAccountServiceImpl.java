package com.xworkz.postOffice.service.impl;

import com.xworkz.postOffice.dao.UserAccountDao;
import com.xworkz.postOffice.dao.impl.UserAccountDaoImpl;
import com.xworkz.postOffice.dto.UserAccountDto;
import com.xworkz.postOffice.entity.UserAccountEntity;
import com.xworkz.postOffice.service.UserAccountService;

public class UserAccountServiceImpl implements UserAccountService {


    @Override
    public boolean save(UserAccountDto userAccountDto) {

        System.out.println("Running save()in UserAccountServiceImpl");
        boolean isSaved=false;

        if(userAccountDto!=null)
        {
            UserAccountEntity userAccountEntity=new UserAccountEntity();

            userAccountEntity.setName(userAccountDto.getName());
            userAccountEntity.setGender(userAccountDto.getGender());
            userAccountEntity.setAge(userAccountDto.getAge());
            userAccountEntity.setAccountNumber(userAccountDto.getAccountNumber());

            UserAccountDao userAccountDao=new UserAccountDaoImpl();
            boolean result=userAccountDao.save(userAccountEntity);

            isSaved=true;
            if(result) {
                System.out.println("Data saved succesfullly in UserAccountDaoImpl");
            }
            else
            {
                System.out.println("Data not saved");
            }
        }
        else
        {
            System.out.println("Data not saved,UserAccountDto is null");
        }

        return isSaved;
    }
}

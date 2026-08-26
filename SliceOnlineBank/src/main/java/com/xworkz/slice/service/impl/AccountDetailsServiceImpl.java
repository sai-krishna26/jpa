package com.xworkz.slice.service.impl;

import com.xworkz.slice.dao.AccountDetailsDao;
import com.xworkz.slice.dao.impl.AccountDetailsDaoImpl;
import com.xworkz.slice.dto.AccountDetailsDto;
import com.xworkz.slice.entity.AccountDetailsEntity;
import com.xworkz.slice.service.AccountDetailsService;

import java.sql.SQLOutput;

public class AccountDetailsServiceImpl implements AccountDetailsService
{
    @Override
    public boolean save(AccountDetailsDto accountDetailsDto) {
        System.out.println("Running save method in AccountDetailsServiceImpl");
        boolean isSaved = false;

        if (accountDetailsDto != null)
        {
            AccountDetailsEntity accountDetailsEntity = new AccountDetailsEntity();

            accountDetailsEntity.setAccountNumber(accountDetailsDto.getAccountNumber());
            accountDetailsEntity.setAccountHolderId(accountDetailsDto.getAccountHolderId());
            accountDetailsEntity.setAccountHolderName(accountDetailsDto.getAccountHolderName());
            accountDetailsEntity.setAge(accountDetailsDto.getAge());
            accountDetailsEntity.setGender(accountDetailsDto.getGender());

            AccountDetailsDao accountDetailsDao = new AccountDetailsDaoImpl();
            Boolean saved=accountDetailsDao.save(accountDetailsEntity);

            if(saved)
            {
                isSaved=true;
                System.out.println("Data saved successfully in AccountDetailsDaoImpl");
            }
            else
            {
                System.out.println("Failed to save data in AccountDetailsDaoImpl");
            }
        }
        return isSaved;
    }
}

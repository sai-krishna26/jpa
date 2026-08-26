package com.xworkz.slice;

import com.xworkz.slice.dto.AccountDetailsDto;
import com.xworkz.slice.entity.AccountDetailsEntity;
import com.xworkz.slice.service.AccountDetailsService;
import com.xworkz.slice.service.impl.AccountDetailsServiceImpl;

import javax.persistence.*;

public class runner {

    public static void main(String[] args) {
        System.out.println("main method started in runner");
        AccountDetailsDto accountDetailsdto=new AccountDetailsDto();

        accountDetailsdto.setAccountNumber(234234);
        accountDetailsdto.setAccountHolderId("U456456");
        accountDetailsdto.setAccountHolderName("Narendra");
        accountDetailsdto.setAge(23);
        accountDetailsdto.setGender("male");

        AccountDetailsService accountDetailsService=new AccountDetailsServiceImpl();
        accountDetailsService.save(accountDetailsdto);
    }
}

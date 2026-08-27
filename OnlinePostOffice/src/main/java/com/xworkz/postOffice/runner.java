package com.xworkz.postOffice;

import com.xworkz.postOffice.dto.UserAccountDto;
import com.xworkz.postOffice.service.UserAccountService;
import com.xworkz.postOffice.service.impl.UserAccountServiceImpl;

public class runner {

    public static void main(String[] args) {
        System.out.println("Online Post Office");

        UserAccountDto userAccountDto=new UserAccountDto();
        userAccountDto.setName("ramesh");
        userAccountDto.setGender("male");
        userAccountDto.setAge(25);
        userAccountDto.setAccountNumber(1234567890);

        UserAccountService userAccountService=new UserAccountServiceImpl();
        userAccountService.save(userAccountDto);
    }
}

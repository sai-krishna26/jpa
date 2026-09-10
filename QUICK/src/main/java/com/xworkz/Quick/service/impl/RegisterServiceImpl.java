package com.xworkz.Quick.service.impl;

import com.xworkz.Quick.dao.RegisterDao;
import com.xworkz.Quick.dao.impl.RegisterDaoImpl;
import com.xworkz.Quick.dto.RegisterDto;
import com.xworkz.Quick.entity.RegisterEntity;
import com.xworkz.Quick.service.RegisterService;
import com.xworkz.Quick.util.ValidationUtil;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class RegisterServiceImpl implements RegisterService {
    Boolean isSaved=false;
    @Override
    public Boolean validateAndsSave(RegisterDto registerDto) {
        System.out.println("Running  save method in service");
        if(registerDto!=null)
        {
            Set<ConstraintViolation<RegisterDto>> violations=ValidationUtil.getValidator().validate(registerDto);
            System.out.println("ref of ConstraintViolation: "+violations);

            if(!registerDto.getPassword().equals(registerDto.getConfirmPassword()))
            {
                System.out.println("Password does not match");
                return false;
            }
            RegisterEntity registerEntity=new RegisterEntity();

            registerEntity.setName(registerDto.getName());
            registerEntity.setEmail(registerDto.getEmail());
            registerEntity.setPassword(registerDto.getPassword());
            registerEntity.setConfirmPassword(registerDto.getConfirmPassword());
            registerEntity.setGraduationDate(registerDto.getGraduationDate());
            registerEntity.setInstitute(registerDto.getInstitute());

            RegisterDao registerDao=new RegisterDaoImpl();
            Boolean result=registerDao.save(registerEntity);

            if(result==true)
            {
                isSaved=true;
                System.out.println("Entity saved successfully");
            }
            else
            {
                isSaved=false;
                System.out.println("Entity not saved");
            }
        }
        return isSaved;
    }
}

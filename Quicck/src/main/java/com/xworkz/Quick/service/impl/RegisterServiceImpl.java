package com.xworkz.Quick.service.impl;

import com.xworkz.Quick.dao.RegisterDao;
import com.xworkz.Quick.dao.impl.RegisterDaoImpl;
import com.xworkz.Quick.dto.RegisterDto;
import com.xworkz.Quick.entity.RegisterEntity;
import com.xworkz.Quick.service.RegisterService;
import com.xworkz.Quick.util.ValidationUtil;

import javax.validation.ConstraintViolation;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RegisterServiceImpl implements RegisterService {
    Boolean isSaved=false;
    RegisterDao registerDao=new RegisterDaoImpl();
    @Override
    public Boolean validateAndSave(RegisterDto registerDto) {
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

    @Override
    public List<RegisterDto> validateAndReadAll() {
        List<RegisterEntity> registerEntityList=registerDao.readAllRegisters();
        if(registerEntityList!=null)
        {
            return registerEntityList.stream().map(entity->new RegisterDto(
                    entity.getId(),
                    entity.getName(),
                    entity.getEmail(),
                    entity.getPassword(),
                    entity.getConfirmPassword(),
                    entity.getGraduationDate(),
                    entity.getInstitute()
            )).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}

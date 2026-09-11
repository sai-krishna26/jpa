package com.xworkz.Quick.dao;

import com.xworkz.Quick.entity.RegisterEntity;

import java.util.List;

public interface RegisterDao {
    public Boolean save(RegisterEntity registerEntity);
    public List<RegisterEntity> readAllRegisters();
}

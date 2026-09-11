package com.xworkz.Quick.service;

import com.xworkz.Quick.dto.RegisterDto;

import java.util.List;

public interface RegisterService {
    public Boolean validateAndSave(RegisterDto registerDto);
    public List<RegisterDto> validateAndReadAll();
}

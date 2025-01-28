package com.xworkz.form.servlet.service;

import com.xworkz.form.servlet.dto.FormDto;

public interface FormService {
    Boolean validateAndSave(FormDto formDto);

}

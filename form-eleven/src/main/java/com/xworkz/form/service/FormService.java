package com.xworkz.form.service;

import com.xworkz.form.dto.FormDto;

public interface FormService {
    Boolean validateAndSave(FormDto formDto);

}

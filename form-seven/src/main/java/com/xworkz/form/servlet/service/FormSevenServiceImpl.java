package com.xworkz.form.servlet.service;

import com.xworkz.form.servlet.dto.FormSevenDto;
import com.xworkz.form.servlet.entity.FormSevenEntity;
import com.xworkz.form.servlet.repository.FormSevenRepository;
import com.xworkz.form.servlet.repository.FormSevenRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class FormSevenServiceImpl implements FormSevenService{
    FormSevenRepository formSevenRespository = new FormSevenRepositoryImpl();

    @Override
    public Boolean validateAndSave(FormSevenDto formSevenDto) {
        System.out.println("save and validate is invoked");
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<FormSevenDto>> validate = validator.validate(formSevenDto);
        if(!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        }else {
            FormSevenEntity formSevenEntity = new FormSevenEntity();
            try{
                BeanUtils.copyProperties(formSevenEntity, formSevenDto);
                System.out.println(formSevenEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            formSevenRespository.save(formSevenEntity);
            System.out.println("All data are validated!!");
        }
        return null;
    }
    }


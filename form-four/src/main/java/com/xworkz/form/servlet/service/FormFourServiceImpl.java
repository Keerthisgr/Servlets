package com.xworkz.form.servlet.service;

import com.xworkz.form.servlet.dto.FormFourDto;
import com.xworkz.form.servlet.entity.FormFourEntity;
import com.xworkz.form.servlet.repository.FormFourRepositoryImpl;
import com.xworkz.form.servlet.repository.FormFourRespository;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class FormFourServiceImpl implements FormFourService{
    FormFourRespository formFourRespository = new FormFourRepositoryImpl();


    @Override
    public Boolean validateAndSave(FormFourDto formFourDto) {
        System.out.println("save and validate is invoked");
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<FormFourDto>> validate = validator.validate(formFourDto);
        if(!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        }else {
            FormFourEntity formFourEntity = new FormFourEntity();
            try{
                BeanUtils.copyProperties(formFourEntity, formFourDto);
                System.out.println(formFourEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            formFourRespository.save(formFourEntity);
            System.out.println("All data are validated!!");
        }
        return null;
            }
        }



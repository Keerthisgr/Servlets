package com.xworkz.form.servlet.service;

import com.xworkz.form.servlet.dto.FormFiveDto;
import com.xworkz.form.servlet.entity.FormFiveEntity;
import com.xworkz.form.servlet.repository.FormFiveRepository;
import com.xworkz.form.servlet.repository.FormFiveRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class FormFiveServiceImpl implements FormFiveService{
    FormFiveRepository formFiveRepository = new FormFiveRepositoryImpl();
    @Override
    public Boolean validateAndSave(FormFiveDto formFiveDto) {
        System.out.println("save and validate is invoked");
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<FormFiveDto>> validate = validator.validate(formFiveDto);
        if(!validate.isEmpty()){
            validate.stream().forEach(error-> System.out.println(error.getMessage()));
        }else{
            FormFiveEntity formFiveEntity = new FormFiveEntity();
            try{
                BeanUtils.copyProperties(formFiveEntity, formFiveDto);
                System.out.println(formFiveEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            formFiveRepository.save(formFiveEntity);
            System.out.println("All data are validated!!");
        }
        return null;
    }
    }


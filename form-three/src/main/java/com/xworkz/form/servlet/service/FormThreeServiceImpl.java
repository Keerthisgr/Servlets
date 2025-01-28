package com.xworkz.form.servlet.service;

import com.xworkz.form.servlet.dto.FormThreeDto;
import com.xworkz.form.servlet.entity.FormThreeEntity;
import com.xworkz.form.servlet.repository.FormThreeRepository;
import com.xworkz.form.servlet.repository.FormThreeRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class FormThreeServiceImpl implements FormThreeService{
    FormThreeRepository formThreeRepository = new FormThreeRepositoryImpl();
    @Override
    public Boolean validateAndSave(FormThreeDto formThreeDto) {
        System.out.println("save and validate is invoked");
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<FormThreeDto>> validate = validator.validate(formThreeDto);
        if(!validate.isEmpty()){
            validate.stream().forEach(error-> System.out.println(error.getMessage()));
        }else{
            FormThreeEntity formThreeEntity = new FormThreeEntity();
            try{
                BeanUtils.copyProperties(formThreeEntity, formThreeDto);
                System.out.println(formThreeEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            formThreeRepository.save(formThreeEntity);
            System.out.println("All data are validated!!");
        }
        return null;
    }
    }


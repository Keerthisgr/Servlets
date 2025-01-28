package com.xworkz.form.servlet.service;

import com.xworkz.form.servlet.dto.FormDto;
import com.xworkz.form.servlet.entity.FormEntity;
import com.xworkz.form.servlet.repository.FormRepository;
import com.xworkz.form.servlet.repository.FormRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class FormServiceImpl implements FormService{
    FormRepository formRepository = new FormRepositoryImpl();

    @Override
    public Boolean validateAndSave(FormDto formDto) {
        System.out.println("save and validate is invoked");
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<FormDto>> validate = validator.validate(formDto);
        if(!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        }else {
            FormEntity formEntity = new FormEntity();
            try{
                BeanUtils.copyProperties(formEntity, formDto);
                System.out.println(formEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            formRepository.save(formEntity);
            System.out.println("All data are validated!!");
        }
        return null;
    }
}

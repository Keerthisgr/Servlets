package com.xworkz.form.service;

import com.xworkz.form.dto.FormDto;
import com.xworkz.form.entity.FormEntity;
import com.xworkz.form.repository.FormRepository;
import com.xworkz.form.repository.FormRepositoryImpl;
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

package com.xworkz.form.service;

import com.xworkz.form.dto.UserProfileDto;
import com.xworkz.form.entity.UserProfileEntity;
import com.xworkz.form.repository.UserProfileRepository;
import com.xworkz.form.repository.UserProfileRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class UserProfileServiceImpl implements UserProfileService {
    UserProfileRepository userProfileRepository = new UserProfileRepositoryImpl();

    @Override
    public Boolean saveAndValidate(UserProfileDto userProfileDto) {
        System.out.println("Save and validate is invoked");
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<UserProfileDto>> validate = validator.validate(userProfileDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            UserProfileEntity userProfileEntity = new UserProfileEntity();
            try {

                BeanUtils.copyProperties(userProfileEntity, userProfileDto);
                System.out.println(userProfileEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
//

            userProfileRepository.save(userProfileEntity);
            System.out.println("All data are validated!!");
        }

        return null;
    }
}

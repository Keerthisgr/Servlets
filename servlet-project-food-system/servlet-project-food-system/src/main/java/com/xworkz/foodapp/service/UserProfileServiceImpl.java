package com.xworkz.foodapp.service;

import com.xworkz.foodapp.dto.UserProfileDto;
import com.xworkz.foodapp.entity.UserProfileEntity;
import com.xworkz.foodapp.repository.UserProfileRepo;
import com.xworkz.foodapp.repository.UserProfileRepoImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserProfileServiceImpl implements UserProfileService {
    UserProfileRepo userProfileRepo = new UserProfileRepoImpl();
    @Override
    public void validateAndSave(UserProfileDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<UserProfileDto>> validate = validator.validate(dto);
        if (validate.isEmpty()){
            UserProfileEntity userProfileEntity =new UserProfileEntity();
            try {
                BeanUtils.copyProperties(userProfileEntity, dto);//get dto,entity
                userProfileRepo.save(userProfileEntity);
                System.out.println(userProfileEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }else {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        }

    }

    @Override
    public List<UserProfileDto> getAllProfiles() {
        List<UserProfileEntity> entityList = userProfileRepo.getAllProfiles();
        List<UserProfileDto> userProfileDtoList = new ArrayList<>();

        if (entityList != null) {
            for (UserProfileEntity userProfileEntity : entityList) {
                UserProfileDto dto = new UserProfileDto();
                try {
                    BeanUtils.copyProperties(dto, userProfileEntity);
                    System.out.println(userProfileDtoList);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                userProfileDtoList.add(dto);
            }
        }
        return userProfileDtoList;
    }

    @Override
    public void deleteUserById(int id) {
        if (userProfileRepo != null) {
            userProfileRepo.deleteUserById(id);
            System.out.println("User profile with id " + id + " deleted successfully");
        } else {
            System.out.println("User profile with id " + id + " not found");
        }
    }

    @Override
    public UserProfileDto getProfileById(int id) {
        UserProfileDto dto = new UserProfileDto();
        if (id>0){
            UserProfileEntity entity = userProfileRepo.getProfileById(id);
            try {
                BeanUtils.copyProperties(dto,entity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        return dto;
    }

    @Override
    public Boolean updateProfile(UserProfileDto dto) {
        UserProfileEntity entity = new UserProfileEntity();
        try {
            BeanUtils.copyProperties(entity,dto);
            boolean isUserProfileUpdated = userProfileRepo.updateProfile(entity);
            if (isUserProfileUpdated){
                System.out.println("User profile updated successfully");
                return true;
            }else  System.out.println("User profile could not be updated");

        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return false;
    }


}

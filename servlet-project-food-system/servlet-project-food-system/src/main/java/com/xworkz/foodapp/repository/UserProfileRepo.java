package com.xworkz.foodapp.repository;

import com.xworkz.foodapp.entity.UserProfileEntity;

import java.util.List;

public interface UserProfileRepo {
    Boolean save(UserProfileEntity userProfileEntity);
    List<UserProfileEntity> getAllProfiles();
    void deleteUserById(int id);

    UserProfileEntity getProfileById(int id);
    Boolean updateProfile(UserProfileEntity entity);
}

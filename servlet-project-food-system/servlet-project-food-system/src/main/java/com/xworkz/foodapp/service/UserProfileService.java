package com.xworkz.foodapp.service;

import com.xworkz.foodapp.dto.UserProfileDto;

import java.util.List;

public interface UserProfileService {
    void validateAndSave(UserProfileDto dto);
    List<UserProfileDto> getAllProfiles();
    void deleteUserById(int id);

    UserProfileDto getProfileById(int id);
    Boolean updateProfile(UserProfileDto dto);
}

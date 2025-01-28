package com.xworkz.form.service;

import com.xworkz.form.dto.UserProfileDto;

public interface UserProfileService {
    Boolean saveAndValidate(UserProfileDto userProfileDto);
}

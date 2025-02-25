package com.xworkz.foodapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class UserProfileDto {
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private long phNumber;
}

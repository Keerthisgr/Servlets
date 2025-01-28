package com.xworkz.form.dto;



import lombok.Data;



@Data

public class UserProfileDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Long cNo;
    private String address;
    private String city;
}

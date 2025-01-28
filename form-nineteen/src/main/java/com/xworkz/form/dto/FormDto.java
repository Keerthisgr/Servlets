package com.xworkz.form.dto;

import lombok.Data;

@Data
public class FormDto {
    private Integer id;
    private String username;
    private String password;
    private String securityQuestion;
    private String securityAnswer;
    private String country;
}

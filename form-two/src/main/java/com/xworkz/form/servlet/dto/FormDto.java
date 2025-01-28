package com.xworkz.form.servlet.dto;

import lombok.Data;

@Data
public class FormDto {
private Integer id;
private String fullName;
private String email;
private Long mobile;
private String gender;
private String dob;
private String password;
private String confirmPassword;
}

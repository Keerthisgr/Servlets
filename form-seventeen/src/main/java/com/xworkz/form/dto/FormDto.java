package com.xworkz.form.dto;

import lombok.Data;

@Data
public class FormDto {
    private Integer userId;
    private String password;
    private String email;
    private Integer age;
    private Long mobile;
}

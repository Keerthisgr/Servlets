package com.xworkz.form.dto;

import lombok.Data;

@Data
public class FormDto {
    private Integer id;
    private String fullName;
    private String email;
    private String dob;
    private Long phone;
    private String nationality;
}

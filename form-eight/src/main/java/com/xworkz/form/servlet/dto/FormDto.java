package com.xworkz.form.servlet.dto;

import lombok.Data;

@Data
public class FormDto {
    private Integer id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Long cNo;
    private String email;
    private String address;
}

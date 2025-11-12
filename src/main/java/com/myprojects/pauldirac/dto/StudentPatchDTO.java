package com.myprojects.pauldirac.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class StudentPatchDTO {

    private String firstName;

    private String lastName;

    @Email(message = "Invalid email format")
    @org.hibernate.validator.constraints.Length(min = 1, message = "Email cannot be blank")
    private String email;
}

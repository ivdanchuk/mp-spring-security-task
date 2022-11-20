package com.example.securitytask.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class SignupDTO {
    //    @NotEmpty(message = "Email cannot be empty")
    //    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    protected String email;

    //    @NotEmpty(message = "Password cannot be empty")
    //    @Min(value = 3, message = "Min length is 3")
    private String password;
}

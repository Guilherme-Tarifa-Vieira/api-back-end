package com.stack.apibooklovers.domain.user;

import com.stack.apibooklovers.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserForm {

    @NotBlank
    @Size(min = 3, max = 155)
    private String firstName;

    @NotBlank
    @Size(min = 3, max = 155)
    private String lastName;
    @NotBlank
    private String email;

    @NotBlank
    private String password;
    private Role role;

}

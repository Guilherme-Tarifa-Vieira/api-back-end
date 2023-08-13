package domain.user;

import enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserResponseDTO {
    @NotBlank
    @Size(min = 3, max = 155)
    private String name;
    @NotBlank
    private String email;

    @NotBlank
    private Role role;


}

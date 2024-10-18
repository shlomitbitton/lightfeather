package com.lightfeather.lightfeather;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestParam;
@Getter
@Setter
public class ManagerRequestDto {

    @NotBlank(message = "First name is required")
    private String firstName;
    @NotBlank(message = "Last name is required")
    private String lastName;
    private String email;
    private String phoneNumber;
    @NotBlank(message = "Supervisor is required")
    private String supervisor;
}

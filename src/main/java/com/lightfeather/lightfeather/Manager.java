package com.lightfeather.lightfeather;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestParam;

@Setter
@Getter
public class Manager {

    private String id;
    private String phoneNumber;
    private String jurisdiction;
    private String identificationNumber;
    private String firstName;
    private String lastName;

}

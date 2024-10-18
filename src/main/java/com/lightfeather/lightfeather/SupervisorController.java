package com.lightfeather.lightfeather;




import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class SupervisorController {

    private final SupervisorService supervisorService;


    public SupervisorController(SupervisorService supervisorService) {
        this.supervisorService = supervisorService;
    }

    @GetMapping("/supervisors")
    public ResponseEntity<List<String>> getSupervisors() {
        List<String> response = supervisorService.getSupervisorList();
        if (!response.isEmpty()) {
            return ResponseEntity.ok(response);
        } else
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
        }


    @PostMapping("/submit")
    public ResponseEntity<String> submitPersonalInformation(@RequestBody ManagerRequestDto personalInfo) {

        if(supervisorService.submitPersonalInformation(personalInfo)){
            return ResponseEntity.ok("Personal information submitted successfully.");
        }else{
            return ResponseEntity.badRequest().body("firstName,lastName, and supervisor are mandatory");
        }

    }
}


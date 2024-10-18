package com.lightfeather.lightfeather;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class SupervisorService {
    private static final String AWS_MANAGER_API_URL = "https://o3m5qixdng.execute-api.us-east-1.amazonaws.com/api/managers";


    public List<String> getSupervisorList(){

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Manager[]> response = restTemplate.getForEntity(AWS_MANAGER_API_URL, Manager[].class);

        if(response.getStatusCode()==HttpStatus.OK &&response.getBody()!=null) {
        List<Manager> managerList = Arrays.asList(response.getBody());
        return  managerList.stream()
                .filter(manager -> !manager.getJurisdiction().matches("\\d+"))
                .sorted(Comparator.comparing(Manager::getLastName)
                        .thenComparing(Manager::getFirstName))
                .map(manager -> String.format(manager.getJurisdiction() ,"%s - %s, %s",
                        manager.getLastName(), manager.getFirstName()))
                .collect(Collectors.toList());
        }else{
            return new ArrayList<>();
        }
    }

    public void submitPersonalInformation(ManagerRequestDto personalInfo){

        System.out.println("Submitted Data:");
        System.out.println("First Name: " + personalInfo.getFirstName());
        System.out.println("Last Name: " + personalInfo.getLastName());
        System.out.println("Email: " + (StringUtils.hasText(personalInfo.getEmail()) ? personalInfo.getEmail() : "Not provided"));
        System.out.println("Phone Number: " + (StringUtils.hasText(personalInfo.getPhoneNumber()) ? personalInfo.getPhoneNumber() : "Not provided"));
        System.out.println("Supervisor: " + personalInfo.getSupervisor());
    }
}

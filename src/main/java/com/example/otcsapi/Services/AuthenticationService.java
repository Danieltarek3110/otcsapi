package com.example.otcsapi.Services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AuthenticationService {

    @Value("${OTCS_BASE_URL}")
    private String OTCS_BASE_URL ;

    public String authenticate(String username , String password){
        String url= OTCS_BASE_URL + "v1/auth";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            throw new RuntimeException("Failed to fetch data from API: " + responseEntity.getStatusCode());
        }
    }
}


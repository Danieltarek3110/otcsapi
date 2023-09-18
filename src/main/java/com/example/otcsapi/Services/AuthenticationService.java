package com.example.otcsapi.Services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;

public class AuthenticationService {

    @Value("${OTCS_BASE_URL}")
    private String OTCS_BASE_URL ;

    public RequestEntity<String> authenticate(String username , String password){
        String url= OTCS_BASE_URL + "v1/auth";
        RequestEntity<String> response = restTemplate.exchange(
            url,
            HttpMethod,


        );
        return response;
    }
}

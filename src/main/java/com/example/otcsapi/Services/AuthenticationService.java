package com.example.otcsapi.Services;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;


@Service
public class AuthenticationService {

    @Value("${BASE_URL}")
    public String BASE_URL ;

    public String authenticate(String username , String password){
        String url= BASE_URL + "v1/auth";

        LinkedMultiValueMap<String , String> map = new LinkedMultiValueMap<>();
        map.add("username", username);
        map.add("password", password);
        HttpEntity<LinkedMultiValueMap<String , String>> body = new HttpEntity<LinkedMultiValueMap<String,String>>(map);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, body, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {

            JSONObject result = new JSONObject(responseEntity.getBody());
            JSONObject response = new JSONObject();

            response.put("tocken" , result.get("ticket"));

            return result.get("ticket").toString();
        } else {
            throw new RuntimeException("Failed to fetch data from API: " + responseEntity.getStatusCode());
        }
    }
}
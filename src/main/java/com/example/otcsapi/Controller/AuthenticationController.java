package com.example.otcsapi.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.otcsapi.Services.AuthenticationService;

import javax.print.attribute.standard.Media;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService AuthService ;

    @PostMapping(value={"" , "/"} , produces = MediaType.APPLICATION_JSON_VALUE)
    public String getTicket(@RequestParam String username , @RequestParam String password) {
        
       String response =  AuthService.authenticate(username, password);

        return response;
    }
}
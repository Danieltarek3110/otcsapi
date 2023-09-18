package com.example.otcsapi.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.otcsapi.Services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.otcsapi.Models.User;


@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService AuthService ;

    @PostMapping(value={"" , "/"} , produces = MediaType.APPLICATION_JSON_VALUE)
    public String getTicket(@RequestBody User usr) {
        
       String response =  AuthService.authenticate(usr.getUsername() , usr.getPassword());

        return response;
    }
}
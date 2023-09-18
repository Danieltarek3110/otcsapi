package com.example.otcsapi.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    
    @Value("${BASE_URL}")
    private String BASE_URL;


    @PostMapping(value={"" , "/"})
    public String getTicket(@RequestParam String username , @RequestParam String password) {
        
        
        return username;
    }
    











}

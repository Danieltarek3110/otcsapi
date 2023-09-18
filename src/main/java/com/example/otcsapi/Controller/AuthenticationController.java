package com.example.otcsapi.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    

    @PostMapping(value={"" , "/"})
    public String authenticate(@RequestBody String entity) {
        
        
        return tocken;
    }
    











}

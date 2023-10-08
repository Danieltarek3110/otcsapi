package com.example.otcsapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.otcsapi.Services.CategoryService;

@RestController
@RequestMapping("/api/v1/Category")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;
    
    @PostMapping(value = {"" , "/"} , produces = MediaType.APPLICATION_JSON_VALUE)
    public String postMethod(){
        return categoryService.assignCategory();
        
    }
}

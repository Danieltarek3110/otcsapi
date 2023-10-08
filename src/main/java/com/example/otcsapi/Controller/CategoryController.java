package com.example.otcsapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.otcsapi.Entity.CatRegionMapEntity;
import com.example.otcsapi.Services.CategoryService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/v1/Category")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;
    
    @GetMapping(value = {"" , "/"} , produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CatRegionMapEntity> getMapping(
    )
    {
        return categoryService.getCategories();
        
    }


    @GetMapping(value = "/{Name}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CatRegionMapEntity> getCategoryByName(
        @PathVariable("Name") String Category
    )
    {
        return categoryService.getCategoryByName(Category);
        
    }
}

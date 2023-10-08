package com.example.otcsapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.otcsapi.Entity.CatRegionMapEntity;
import com.example.otcsapi.Services.CategoryService;

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


    @GetMapping(value = {"" , "/"} , produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CatRegionMapEntity> getCatByName(
        @RequestParam("Category") String Category
    )
    {
        return categoryService.getCategoryByName(Category);
        
    }
}

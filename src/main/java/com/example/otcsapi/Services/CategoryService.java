package com.example.otcsapi.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.otcsapi.DatabaseRepository.CategoriesRepository;
import com.example.otcsapi.Entity.CatRegionMapEntity;

@Service
public class CategoryService {
    
    @Value("${BASE_URL}")
    private String base_url;

    @Autowired
    private CategoriesRepository repo;
    
    
    public String assignCategory(){
        return "";
    }


    public List<CatRegionMapEntity> ListCat() {
        return repo.getAll();
    }
}

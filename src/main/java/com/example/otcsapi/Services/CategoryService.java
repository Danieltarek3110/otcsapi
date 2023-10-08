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
    
    public List<CatRegionMapEntity> getCategories() {
        return repo.getAll();
    }

        public List<CatRegionMapEntity> ListCatByName(String Category) {
        return repo.getCategoryByName(Category);
    }
}

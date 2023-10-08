package com.example.otcsapi.DatabaseRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.otcsapi.Entity.CatRegionMapEntity;

public interface CategoriesRepository extends JpaRepository<CatRegionMapEntity , Long> {
    @Query("SELECT d FROM CatRegionMapEntity d WHERE ")
    public List<CatRegionMapEntity> getAll();


}

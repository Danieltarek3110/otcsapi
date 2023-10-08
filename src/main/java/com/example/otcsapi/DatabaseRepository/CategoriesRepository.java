package com.example.otcsapi.DatabaseRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.otcsapi.Entity.DTreeCoreEntity;

public interface CategoriesRepository extends JpaRepository<DTreeCoreEntity , Long> {
    
}

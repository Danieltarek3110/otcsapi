package com.example.otcsapi.DatabaseRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.otcsapi.Entity.DTreeCore;

@Repository
public interface DatabaseRepository extends JpaRepository<DTreeCore , String>{

    
}

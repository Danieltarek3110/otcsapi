package com.example.otcsapi.DatabaseRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.otcsapi.Entity.DTreeCoreEntity;

@Repository
public interface DatabaseRepository extends JpaRepository<DTreeCoreEntity , Long>{

    @Query("SELECT d FROM DTreeCoreEntity d WHERE d.ParentID = 2000")
    public List<DTreeCoreEntity> getAll();

}

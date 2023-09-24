package com.example.otcsapi.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.otcsapi.Entity.DTreeCoreEntity; 

import com.example.otcsapi.DatabaseRepository.DatabaseRepository;

@Service
public class DocumentService {
    @Autowired
    private DatabaseRepository repo;

    public String uploadDocument(MultipartFile file , String parentId){
        
        
        
        
        return "";
    }

    
    public List<DTreeCoreEntity> ListDtree(){
        return repo.getAll();
    }


}

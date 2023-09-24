package com.example.otcsapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.example.otcsapi.Entity.DTreeCoreEntity;
import com.example.otcsapi.Services.DocumentService;



@RestController
@RequestMapping("/api/v1/document")
public class DocumentController {


    @Autowired
    private DocumentService documentService;

    @PostMapping(value={"","/"} , produces = MediaType.APPLICATION_JSON_VALUE) 
    public String postMethod(@RequestParam("file") MultipartFile file ,
    @RequestParam("fullpath") String fullpath , 
    @RequestParam("username") String username ,
     @RequestParam("password") String password) 
     {
        return documentService.uploadDocument(file , fullpath , username , password ); 
     }
    

    @GetMapping(value={"","/"} , produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DTreeCoreEntity> getAllDocs() {
        return documentService.ListDtree();
    }
    
    
}

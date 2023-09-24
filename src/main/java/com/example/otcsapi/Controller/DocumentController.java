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

    @PostMapping(value={"","/"} , produces = MediaType.MULTIPART_FORM_DATA_VALUE) 
    public String postMethod(@RequestParam MultipartFile file ) {
        
        documentService.uploadDocument(file , "2000" );
        return " " ; 
    }
    

    @GetMapping(value={"","/"} , produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DTreeCoreEntity> getAllDocs() {
        return documentService.ListDtree();
    }
    
    
}

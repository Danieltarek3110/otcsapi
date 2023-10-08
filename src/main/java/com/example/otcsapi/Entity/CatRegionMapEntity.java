package com.example.otcsapi.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "CatRegionMap")
public class CatRegionMapEntity {

    @jakarta.persistence.Id
    @Column(name = "CatID")
    private int CatID;

    @Column(name = "CatName")
    private String CatName ;

    @Column(name ="AttrName")
    private String AttrName;
    
}

package com.example.otcsapi.Entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "DTreeCore")
public class DTreeCore {
    @Id
    @Column(name = "DataID")
    private String DataID;

    @Column(name = "OwnerID")
    private String OwnerID;
    
    @Column(name = "Name")
    private String Name;


    
    public DTreeCore() {
    }
    public DTreeCore(String dataID, String ownerID, String name) {
        DataID = dataID;
        OwnerID = ownerID;
        Name = name;
    }
    public String getDataID() {
        return DataID;
    }
    public void setDataID(String dataID) {
        DataID = dataID;
    }
    public String getOwnerID() {
        return OwnerID;
    }
    public void setOwnerID(String ownerID) {
        OwnerID = ownerID;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }



    
}

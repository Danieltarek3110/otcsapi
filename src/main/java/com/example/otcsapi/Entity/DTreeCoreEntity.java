package com.example.otcsapi.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "DTreeCore")
public class DTreeCoreEntity {
    
    @jakarta.persistence.Id
    @Column(name = "DataID")
    private long DataID;

    @Column(name = "OwnerID")
    private String OwnerID;
    
    @Column(name = "Name")
    private String Name;

    @Column(name = "ParentID")
    private int ParentID;

    public long getDataID() {
        return DataID;
    }

    public void setDataID(long dataID) {
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

    public int getParentID() {
        return ParentID;
    }

    public void setParentID(int parentID) {
        ParentID = parentID;
    }

    public DTreeCoreEntity(long dataID, String ownerID, String name, int parentID) {
        DataID = dataID;
        OwnerID = ownerID;
        Name = name;
        ParentID = parentID;
    }

    public DTreeCoreEntity() {
    }


}

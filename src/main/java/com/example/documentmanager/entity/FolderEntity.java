package com.example.documentmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "project")
@Entity
public class FolderEntity extends CoreEntity {

    @Column(name = "folder_color")
    private String color;


    @ManyToOne
    private FolderEntity project;

    public FolderEntity getFolder() {
        return project;
    }

    public void setFolder(FolderEntity folder) {
        this.project = folder;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}




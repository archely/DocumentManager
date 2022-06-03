package com.example.documentmanager.entity;

import javax.persistence.*;

@Table(name = "folder")
@Entity
public class FolderEntity extends CoreEntity {

    @Column(name = "folder_color")
    private String color;



    public String getColor() {
        return color;
    }

    public void setColor(String color) {

        this.color = color;
    }


}




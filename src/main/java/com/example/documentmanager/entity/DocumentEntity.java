package com.example.documentmanager.entity;

import javax.persistence.*;
import javax.print.Doc;
import java.util.Date;

@Entity
@Table(name = "document")
public class DocumentEntity extends CoreEntity {

    @Column(name = "document_type")
    private String type;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}

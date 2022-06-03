package com.example.documentmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.print.Doc;
import java.util.Date;

@Entity
@Table(name = "task")
public class DocumentEntity extends CoreEntity {

    @Column(name = "document_type")
    private String type;



    @ManyToOne
    private DocumentEntity project;

    public DocumentEntity getDocument() {
        return project;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

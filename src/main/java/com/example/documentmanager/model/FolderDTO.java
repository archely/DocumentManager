package com.example.documentmanager.model;

public class FolderDTO {

    private Long id;
    private String name;
    private String description;
    private String color;
    private Long documentId;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public String getColor() {

        return color;
    }

    public void setColor(String color) {

        this.color = color;
    }

    public Long getDocumentId() {

        return documentId;
    }

    public void setDocumentId(Long documentId) {

        this.documentId = documentId;
    }


}

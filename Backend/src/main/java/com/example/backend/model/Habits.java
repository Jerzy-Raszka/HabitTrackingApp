package com.example.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Habits")
public class Habits {
    //TODO: implement DTO and remove set and get
    @Id
    private String id;
    private String habitLabel;

    public Habits(String habitLabel) {
        this.habitLabel = habitLabel;
    }

    public String getLabel() {
        return habitLabel;
    }

    public void setLabel(String habitLabel) {
        this.habitLabel = habitLabel;
    }

    public String getId() {
        return id;
    }
}

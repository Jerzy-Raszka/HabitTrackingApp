package com.example.backend.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("Habits")
public class Habits {
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
}

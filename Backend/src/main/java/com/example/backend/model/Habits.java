package com.example.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Habits")
public class Habits {
    @Id
    private String id;
    private String habitLabel;

    public Habits(String habitLabel) {
        this.habitLabel = habitLabel;
    }

    //Used for sake of serialization
    public String getId() {
        return id;
    }

    //Used for sake of serialization
    public String getLabel() {
        return habitLabel;
    }

    public void setLabel(String habitLabel) {
        this.habitLabel = habitLabel;
    }


}

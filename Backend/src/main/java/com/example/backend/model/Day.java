package com.example.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document("Day")
public class Day {
    private final String date;
    private final List<String> fulfilledHabits;
    @Id
    private String id;

    public Day(String date) {
        this.date = date;
        this.fulfilledHabits = new ArrayList<>();
    }

    //Used for sake of serialization
    public String getId() {
        return id;
    }

    //Used for sake of serialization
    public String getDate() {
        return date;
    }

    //Used for sake of serialization
    public List<String> getFulfilledHabits() {
        return fulfilledHabits;
    }

    public void addHabit(String habitID) {
        this.fulfilledHabits.add(habitID);
    }

    public void removeHabit(String habitID) {
        this.fulfilledHabits.remove(habitID);
    }
}

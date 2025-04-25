package com.example.backend.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document("Day")
public class Day {
    private final String date;
    private final List<String> fulfilledHabits;

    public Day(String data) {
        this.date = data;
        this.fulfilledHabits = new ArrayList<>();
    }

    public String getDate() {
        return date;
    }

    public List<String> getFulfilledHabits() {
        return fulfilledHabits;
    }

    public void addHabit(String habitID) {
        this.fulfilledHabits.add(habitID);
    }
}

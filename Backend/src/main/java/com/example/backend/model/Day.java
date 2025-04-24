package com.example.backend.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document("Day")
public class Day {
    private final String date;
    private final List<Integer> fulfilledHabits;

    public Day(String data) {
        this.date = data;
        this.fulfilledHabits = new ArrayList<>();
    }

    public String getDate() {
        return date;
    }

    public List<Integer> getFulfilledHabits() {
        return fulfilledHabits;
    }

    public void addHabit(int habitID) {
        this.fulfilledHabits.add(habitID);
    }
}

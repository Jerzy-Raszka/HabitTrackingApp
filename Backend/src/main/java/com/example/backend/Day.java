package com.example.backend;

import java.util.ArrayList;
import java.util.List;

public class Day {
    String date;
    List<Integer> fulfilledHabits;

    public Day(String data) {
        this.date = data;
        this.fulfilledHabits = new ArrayList<>();
    }

    public void markHabit(int habitID) {
        this.fulfilledHabits.add(habitID);
    }
}

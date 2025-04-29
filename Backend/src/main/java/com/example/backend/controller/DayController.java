package com.example.backend.controller;

import com.example.backend.model.Day;
import com.example.backend.repository.DayRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class DayController {
    final DayRepository dayRepo;
    List<String> fulfilledHabitsList = new ArrayList<>();

    public DayController(DayRepository dayRepo) {
        this.dayRepo = dayRepo;
    }

    public void addFulfilledHabit(String date, String id) {
        Day day = dayRepo.findFirstByDate(date);
        day.addHabit(id);
    }

    public void addDay(String date) {
        dayRepo.save(new Day(date));
    }

    public void fulfilledHabit(String dayId) {
        Optional<Day> day = dayRepo.findById(dayId);
        day.ifPresent((Day habitFulfilled) -> fulfilledHabitsList = habitFulfilled.getFulfilledHabits());
    }
}

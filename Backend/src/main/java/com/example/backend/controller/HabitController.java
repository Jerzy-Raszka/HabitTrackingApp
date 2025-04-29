package com.example.backend.controller;

import com.example.backend.model.Habits;
import com.example.backend.repository.HabitRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//TODO:  Rest 
@RestController
public class HabitController {
    final HabitRepository habitRepo;
    List<Habits> habitsList = new ArrayList<>();

    public HabitController(HabitRepository habitRepo) {
        this.habitRepo = habitRepo;
    }

    public void createHabit(String label) {
        habitRepo.save(new Habits(label));
    }

    public void getHabits() {
        habitsList = habitRepo.findAll();
    }

    public void deleteHabit(String id) {
        habitRepo.deleteById(id);
    }

    public void editHabit(String id, String label) {
        Optional<Habits> habit = habitRepo.findById(id);
        habit.ifPresent((Habits habitToUpdate) -> {
            habitToUpdate.setLabel(label);
            habitRepo.save(habitToUpdate);
        });
    }
}

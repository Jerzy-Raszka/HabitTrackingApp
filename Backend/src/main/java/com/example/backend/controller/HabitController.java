package com.example.backend.controller;

import com.example.backend.model.Habits;
import com.example.backend.repository.HabitRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HabitController {
    final HabitRepository habitRepo;
    List<Habits> habits = new ArrayList<>();

    public HabitController(HabitRepository habitRepo) {
        this.habitRepo = habitRepo;
    }

    @GetMapping("/")
    public ResponseEntity<List<Habits>> getAllHabits() {
        habits = habitRepo.findAll();
        return ResponseEntity.ok(habits);
    }

    @PostMapping("/")
    public ResponseEntity<Habits> addHabit(@RequestParam String label) {
        Habits habit = new Habits(label);
        habit = habitRepo.save(habit);
        return ResponseEntity.ok(habit);
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> deleteHabit(@RequestParam String id) {
        if (!habitRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        habitRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/")
    public ResponseEntity<Habits> updateHabit(@RequestParam String id, @RequestParam String label) {
        Habits habit = habitRepo.findById(id).orElse(null);
        if (habit != null) {
            habit.setLabel(label);
            return ResponseEntity.ok(habitRepo.save(habit));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

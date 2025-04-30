package com.example.backend.controller;

import com.example.backend.model.Habits;
import com.example.backend.repository.HabitRepository;
import com.example.backend.service.HabitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HabitController {
    final HabitRepository habitRepo;
    final HabitService habitService;

    public HabitController(HabitRepository habitRepo, HabitService habitService) {
        this.habitRepo = habitRepo;
        this.habitService = habitService;
    }


    @GetMapping("/Habit")
    public ResponseEntity<List<Habits>> getAllHabits() {
        return habitService.getAllHabits();
    }

    @PostMapping("/Habit")
    public ResponseEntity<Habits> addHabit(@RequestParam String label) {
        return habitService.addHabit(label);
    }

    @DeleteMapping("/Habit")
    public ResponseEntity<Void> deleteHabit(@RequestParam String id) {
        return habitService.deleteHabit(id);
    }

    @PatchMapping("/Habit")
    public ResponseEntity<Habits> updateHabit(@RequestParam String id, @RequestParam String label) {
        return habitService.updateHabit(id, label);
    }

}

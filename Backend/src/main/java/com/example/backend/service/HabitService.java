package com.example.backend.service;

import com.example.backend.model.Habits;
import com.example.backend.repository.HabitRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitService {

    final HabitRepository habitRepo;

    public HabitService(HabitRepository habitRepo) {
        this.habitRepo = habitRepo;
    }

    public ResponseEntity<List<Habits>> getAllHabits() {
        return ResponseEntity.ok(habitRepo.findAll());
    }

    public ResponseEntity<Habits> addHabit(String label) {
        Habits habit = new Habits(label);
        habitRepo.save(habit);
        return ResponseEntity.ok(habit);
    }

    public ResponseEntity<Void> deleteHabit(String id) {
        if (!habitRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        } else {
            habitRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }

    public ResponseEntity<Habits> updateHabit(String id, String label) {
        Habits habit = habitRepo.findById(id).orElse(null);
        if (habit != null) {
            habit.setLabel(label);
            return ResponseEntity.ok(habitRepo.save(habit));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

package com.example.backend.service;

import com.example.backend.model.Day;
import com.example.backend.repository.DayRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DayService {

    final DayRepository dayRepository;

    public DayService(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
    }

    public ResponseEntity<Day> getDayByDate(String date) {
        return ResponseEntity.ok(dayRepository.findFirstByDate(date));
    }

    public ResponseEntity<Day> addDay(String date) {
        return ResponseEntity.ok(dayRepository.save(new Day(date)));
    }

    public ResponseEntity<Day> addFulfilledHabit(String dayId, String habitId) {
        Day modifiedDay = dayRepository.findById(dayId).orElse(null);
        if (modifiedDay != null) {
            modifiedDay.addHabit(habitId);
            return ResponseEntity.ok(dayRepository.save(modifiedDay));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Day> removeFulfilledHabit(String dayId, String habitId) {
        Day modifiedDay = dayRepository.findById(dayId).orElse(null);
        if (modifiedDay != null) {
            modifiedDay.removeHabit(habitId);
            dayRepository.save(modifiedDay);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> deleteDay(String dayId) {
        if (!dayRepository.existsById(dayId)) {
            return ResponseEntity.notFound().build();
        } else {
            dayRepository.deleteById(dayId);
            return ResponseEntity.noContent().build();
        }

    }

}

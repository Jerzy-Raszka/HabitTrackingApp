package com.example.backend.controller;

import com.example.backend.model.Day;
import com.example.backend.repository.DayRepository;
import com.example.backend.service.DayService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DayController {

    final DayRepository dayRepo;
    final DayService dayService;

    public DayController(DayRepository dayRepo, DayService dayService) {
        this.dayRepo = dayRepo;
        this.dayService = dayService;
    }

    @GetMapping("/Day")
    public ResponseEntity<Day> getDayByDate(@RequestParam String date) {
        return dayService.getDayByDate(date);
    }

    @PostMapping("/Day")
    public ResponseEntity<Day> addDay(@RequestParam String date) {
        return dayService.addDay(date);
    }

    @PatchMapping("/DayAddHabit")
    public ResponseEntity<Day> addFulfilledHabit(@RequestParam String dayId, @RequestParam String habitId) {
        return dayService.addFulfilledHabit(dayId, habitId);
    }

    @PatchMapping("/DayRemoveHabit")
    public ResponseEntity<Day> removeFulfilledHabit(@RequestParam String dayId, @RequestParam String habitId) {
        return dayService.removeFulfilledHabit(dayId, habitId);
    }

    @DeleteMapping("/Day")
    public ResponseEntity<Void> deleteDay(@RequestParam String dayId) {
        return dayService.deleteDay(dayId);
    }
}

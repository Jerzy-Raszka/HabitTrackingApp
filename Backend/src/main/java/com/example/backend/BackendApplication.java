package com.example.backend;

import com.example.backend.model.Day;
import com.example.backend.model.Habits;
import com.example.backend.repository.DayRepository;
import com.example.backend.repository.HabitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EnableMongoRepositories
public class BackendApplication implements CommandLineRunner {

    final HabitRepository habitRepo;
    final DayRepository dayRepo;
    List<Habits> habitsList = new ArrayList<Habits>();
    List<String> fulfilledHabitsList = new ArrayList<String>();

    public BackendApplication(HabitRepository habitRepo, DayRepository dayRepo) {
        this.habitRepo = habitRepo;
        this.dayRepo = dayRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    //TODO: RESTful API

    public void run(String... args) throws Exception {
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

    public void addFulfilledHabit(String date, String id) {
        Day day = dayRepo.findFirstByDate(date);
        day.addHabit(id);
    }

    public void addDay(String date) {
        dayRepo.save(new Day(date));
    }

    public void fulfilledHabit(String dayId) {
        Optional<Day> day = dayRepo.findById(dayId);
        day.ifPresent((Day habitFulfilled) -> {
            fulfilledHabitsList = habitFulfilled.getFulfilledHabits();
        });
    }
}

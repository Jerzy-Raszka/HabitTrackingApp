package com.example.backend;

import com.example.backend.model.Habits;
import com.example.backend.repository.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
public class BackendApplication implements CommandLineRunner {

    @Autowired
    HabitRepository habitRepo;

    List<Habits> habitsList = new ArrayList<Habits>();

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    //TODO: Add day repo
    //TODO: Add geAllHabits, deleteHabit, nameChangeHabit, addIdOfCompletedHabit, newDay methods

    public void run(String... args) throws Exception {
        habitRepo.deleteAll();
        createHabit("kupka");
    }

    void createHabit(String label) {
        habitRepo.save(new Habits(label));
    }
}

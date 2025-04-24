package com.example.backend.repository;

import com.example.backend.model.Habits;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HabitRepository extends MongoRepository<Habits, String> {
}

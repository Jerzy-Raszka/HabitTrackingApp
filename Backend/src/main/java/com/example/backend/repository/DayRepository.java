package com.example.backend.repository;

import com.example.backend.model.Day;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DayRepository extends MongoRepository<Day, String> {

    Day findFirstByDate(String date);

}

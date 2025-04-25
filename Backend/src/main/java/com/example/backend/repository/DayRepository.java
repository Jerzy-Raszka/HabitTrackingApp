package com.example.backend.repository;

import com.example.backend.model.Day;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface DayRepository extends MongoRepository<Day, String> {

    @Query(value = "{date:  '?0'}")
    Day findFirstByDate(String date);

}

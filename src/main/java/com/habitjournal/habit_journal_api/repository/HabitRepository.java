package com.habitjournal.habit_journal_api.repository;

import com.habitjournal.habit_journal_api.model.Habit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HabitRepository extends MongoRepository<Habit, String>, CustomHabitRepository{
    Optional<Habit> findByName(String name);
}

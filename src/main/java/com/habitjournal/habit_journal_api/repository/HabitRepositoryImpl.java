package com.habitjournal.habit_journal_api.repository;

import com.habitjournal.habit_journal_api.model.Habit;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class HabitRepositoryImpl implements CustomHabitRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public List<Habit> findHabitsLoggedSince(LocalDateTime sinceDate) {

        Query query = new Query();

        query.addCriteria(
                Criteria.where("logEntries").elemMatch(
                    Criteria.where("entryDate").gte(sinceDate)
        ));

        return mongoTemplate.find(query, Habit.class);
    }
}

package com.habitjournal.habit_journal_api.repository;

import com.habitjournal.habit_journal_api.model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitRepository extends JpaRepository<Habit, Long> {

}

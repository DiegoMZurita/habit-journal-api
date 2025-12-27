package com.habitjournal.habit_journal_api.repository;

import com.habitjournal.habit_journal_api.model.Habit;

import java.time.LocalDateTime;
import java.util.List;

public interface CustomHabitRepository {
    List<Habit> findHabitsLoggedSince(LocalDateTime sinceDate);
}

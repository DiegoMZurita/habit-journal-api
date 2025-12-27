package com.habitjournal.habit_journal_api.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LogEntry {
    private LocalDateTime entryDate;
}

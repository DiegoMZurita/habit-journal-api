package com.habitjournal.habit_journal_api.controller.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class HabitRequestDTO {
    private String name;
    private List<LocalDateTime> logs;
}

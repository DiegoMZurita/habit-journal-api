package com.habitjournal.habit_journal_api.controller.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class HabitRequestDTO {
    @NotEmpty(message = "El nombre del hábito no puede estar vacío.")
    private String name;
    private List<LocalDateTime> logs;
}

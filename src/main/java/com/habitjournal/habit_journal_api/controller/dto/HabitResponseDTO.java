package com.habitjournal.habit_journal_api.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HabitResponseDTO {
    private Long id;
    private String name;
}

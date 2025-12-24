package com.habitjournal.habit_journal_api.controller;

import com.habitjournal.habit_journal_api.controller.dto.HabitRequestDTO;
import com.habitjournal.habit_journal_api.controller.dto.HabitResponseDTO;
import com.habitjournal.habit_journal_api.service.HabitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/habits")
@RequiredArgsConstructor
public class HabitController {

    private final HabitService habitService;

    @PostMapping
    public void createNewHabit(@RequestBody HabitRequestDTO habitRequestDTO) {
        habitService.createNewHabit(habitRequestDTO);
    }

    @GetMapping
    public ResponseEntity<List<HabitResponseDTO>> findAllHabits() {
        List<HabitResponseDTO> habitResponseDTOS = habitService.getAllHabits();

        return ResponseEntity.ok(habitResponseDTOS);
    }
}

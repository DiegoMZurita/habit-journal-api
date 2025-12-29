package com.habitjournal.habit_journal_api.controller;

import com.habitjournal.habit_journal_api.controller.dto.HabitRequestDTO;
import com.habitjournal.habit_journal_api.controller.dto.HabitResponseDTO;
import com.habitjournal.habit_journal_api.service.HabitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/habits")
@RequiredArgsConstructor
public class HabitController {

    private final HabitService habitService;

    @PostMapping
    public ResponseEntity<HabitResponseDTO> createNewHabit(@Valid @RequestBody HabitRequestDTO habitRequestDTO) {
        HabitResponseDTO responseDTO = habitService.createNewHabit(habitRequestDTO);

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<HabitResponseDTO>> findAllHabits() {
        List<HabitResponseDTO> habitResponseDTOS = habitService.findAllHabits();

        return ResponseEntity.ok(habitResponseDTOS);
    }

    @GetMapping("/active")
    public ResponseEntity<List<HabitResponseDTO>> getActiveHabits(@RequestParam(defaultValue = "7") int days){
        return ResponseEntity.ok(habitService.findHabitsLoggedSince(days));
    }
}

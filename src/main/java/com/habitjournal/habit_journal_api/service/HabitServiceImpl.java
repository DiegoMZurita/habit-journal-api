package com.habitjournal.habit_journal_api.service;

import com.habitjournal.habit_journal_api.controller.dto.HabitRequestDTO;
import com.habitjournal.habit_journal_api.controller.dto.HabitResponseDTO;
import com.habitjournal.habit_journal_api.model.Habit;
import com.habitjournal.habit_journal_api.model.LogEntry;
import com.habitjournal.habit_journal_api.repository.HabitRepository;
import com.habitjournal.habit_journal_api.service.exceptions.DuplicateHabitException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
public class HabitServiceImpl  implements  HabitService {

    private final HabitRepository habitRepository;

    @Override
    @Transactional
    public HabitResponseDTO createNewHabit(HabitRequestDTO requestDTO) {
        habitRepository.findByName(requestDTO.getName()).ifPresent(habit -> {
            throw new DuplicateHabitException(requestDTO.getName());
        });

        Habit newHabit = new Habit();
        newHabit.setName(requestDTO.getName());

        if(requestDTO.getLogs() != null && !requestDTO.getLogs().isEmpty()){
            for(LocalDateTime date: requestDTO.getLogs()){
                LogEntry log = new LogEntry();
                log.setEntryDate(date);
                log.setHabit(newHabit);

                newHabit.getLogEntries().add(log);
            }
        }

        Habit habit = habitRepository.save(newHabit);

        return mapToResponseDto(habit);
    }

    @Override
    @Transactional(readOnly = true)
    public List<HabitResponseDTO> getAllHabits() {
        List<Habit> habits = habitRepository.findAllWithLogs();

        return habits.stream().map(this::mapToResponseDto)
                .toList();
    }

    private HabitResponseDTO mapToResponseDto(Habit habit) {
        List<LocalDateTime> logDates = habit.getLogEntries().stream()
                .map(LogEntry::getEntryDate).toList();

        return new HabitResponseDTO(habit.getId(), habit.getName(), logDates);
    }
}

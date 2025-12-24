package com.habitjournal.habit_journal_api.service;

import com.habitjournal.habit_journal_api.controller.dto.HabitRequestDTO;
import com.habitjournal.habit_journal_api.controller.dto.HabitResponseDTO;
import com.habitjournal.habit_journal_api.model.Habit;
import com.habitjournal.habit_journal_api.repository.HabitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
public class HabitServiceImpl  implements  HabitService {

    private final HabitRepository habitRepository;

    @Override
    public void createNewHabit(HabitRequestDTO requestDTO) {
        if(requestDTO.getName()==null || requestDTO.getName().trim().isEmpty()){
            System.out.println("Error de la lógica de negocios.");
            return;
        }
        System.out.println("Servicio: Mapeando de DTO a Habit");
        Habit newHabit = new Habit();
        newHabit.setName(requestDTO.getName());

        habitRepository.save(newHabit);

        System.out.println("Habito ingresado correctamente.");
    }

    @Override
    public List<HabitResponseDTO> getAllHabits() {
        List<Habit> habits = habitRepository.findAll();

        return habits.stream().map(habit -> new HabitResponseDTO(habit.getId(), habit.getName()))
                .toList();
    }
}

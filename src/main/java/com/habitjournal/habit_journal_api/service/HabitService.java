package com.habitjournal.habit_journal_api.service;

import com.habitjournal.habit_journal_api.controller.dto.HabitRequestDTO;
import com.habitjournal.habit_journal_api.model.Habit;
import com.habitjournal.habit_journal_api.repository.HabitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HabitService {

    private final HabitRepository habitRepository;

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
}

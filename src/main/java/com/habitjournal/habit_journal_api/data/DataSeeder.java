package com.habitjournal.habit_journal_api.data;

import com.habitjournal.habit_journal_api.model.Habit;
import com.habitjournal.habit_journal_api.model.LogEntry;
import com.habitjournal.habit_journal_api.repository.HabitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final HabitRepository habitRepository;

    @Override
    public void run(String... args) throws Exception {
        // Solo insertamos si la base de datos está vacía
        if (habitRepository.count() == 0) {
            Habit habit = new Habit();
            habit.setName("Aprender Arquitectura");

            // Simulamos que cumplimos el hábito hoy y hace 2 días
            LogEntry log1 = new LogEntry();
            log1.setEntryDate(LocalDateTime.now().minusDays(2));
            log1.setHabit(habit); // Importante: vincular al padre

            LogEntry log2 = new LogEntry();
            log2.setEntryDate(LocalDateTime.now());
            log2.setHabit(habit);

            // Añadimos a la lista del padre
            habit.getLogEntries().addAll(List.of(log1, log2));

            // Guardamos (el CascadeType.ALL guardará los registros también)
            habitRepository.save(habit);

            System.out.println("✅ Datos de prueba cargados!");
        }
    }
}

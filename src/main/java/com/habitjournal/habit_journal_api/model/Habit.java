package com.habitjournal.habit_journal_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "habits")
public class Habit {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}

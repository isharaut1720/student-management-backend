package com.project.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String action; // ADD, UPDATE, DELETE
    private String name;
    private String email;
    private String course;
    private String phone;

    private LocalDateTime time;
}
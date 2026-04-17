package com.project.backend.repository;

import com.project.backend.entity.StudentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentHistoryRepository extends JpaRepository<StudentHistory, Long> {
}
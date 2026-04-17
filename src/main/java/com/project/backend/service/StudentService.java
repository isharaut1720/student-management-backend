package com.project.backend.service;

import com.project.backend.entity.*;
import com.project.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    @Autowired
    private StudentHistoryRepository historyRepo;

    public Student saveStudent(Student student) {
        Student saved = repo.save(student);
        saveHistory(saved, "ADD");
        return saved;
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public List<Student> searchStudents(String name) {
        return repo.findByNameContainingIgnoreCase(name);
    }

    public void deleteStudent(Long id) {
        Student s = repo.findById(id).orElseThrow();
        saveHistory(s, "DELETE");
        repo.deleteById(id);
    }

    public Student updateStudent(Long id, Student newStudent) {
        return repo.findById(id).map(s -> {

            s.setName(newStudent.getName());
            s.setEmail(newStudent.getEmail());
            s.setCourse(newStudent.getCourse());
            s.setPhone(newStudent.getPhone());

            Student updated = repo.save(s);
            saveHistory(updated, "UPDATE");

            return updated;
        }).orElseThrow();
    }

    private void saveHistory(Student s, String action) {
        StudentHistory h = new StudentHistory();
        h.setName(s.getName());
        h.setEmail(s.getEmail());
        h.setCourse(s.getCourse());
        h.setPhone(s.getPhone());
        h.setAction(action);
        h.setTime(LocalDateTime.now());

        historyRepo.save(h);
    }
}

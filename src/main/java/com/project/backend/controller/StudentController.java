package com.project.backend.controller;

import com.project.backend.entity.Student;
import com.project.backend.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    // ➕ Add Student
    @PostMapping
    public Student add(@RequestBody Student s) {
        return service.saveStudent(s);
    }

    // 📄 Get All Students
    @GetMapping
    public List<Student> getAll() {
        return service.getAllStudents();
    }

    // 🔍 Search Students
    @GetMapping("/search")
    public List<Student> search(@RequestParam String name) {
        return service.searchStudents(name);
    }

    // ✏️ Update Student
    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student s) {
        return service.updateStudent(id, s);
    }

    // ❌ Delete Student
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteStudent(id);
        return "Student deleted successfully";
    }
}
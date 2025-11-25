package com.example.LMS.controller;

import com.example.LMS.entity.Library;
import com.example.LMS.entity.Student;
import com.example.LMS.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        try {
            return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED);
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/getAllStudents")
    public ResponseEntity<List<Student>> getAllStudents() {
        try {
            return new ResponseEntity<>(studentService.getAllStudents(),HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/getStudentById/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }
    @DeleteMapping("/deleteStudentById/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable long id)
    {
        return ResponseEntity.ok(studentService.deleteStudentById(id));
    }
    @PutMapping("/updateStudentById/{id}")
    public ResponseEntity<String> updateStudentById(@PathVariable long id, @RequestBody Student student ) {
        return ResponseEntity.ok(studentService.updateStudentById(id, student));
    }
}

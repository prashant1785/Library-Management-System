package com.example.LMS.service;

import com.example.LMS.entity.Library;
import com.example.LMS.entity.Student;
import com.example.LMS.exception.ResourceNotFoundException;
import com.example.LMS.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public String addStudent(Student student){
        studentRepo.save(student);
        return "Student Successfully Added";
    }
    public List<Student> getAllStudents()
    {
        return studentRepo.findAll();
    }
    public Student getStudentById(long id)
    {
        return studentRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Student not found with this id: "+ id));
    }
    public String deleteStudentById(long id)
    {
        if (!studentRepo.existsById(id))
        {
            throw new ResourceNotFoundException("Student not found with this id: "+ id);
        }
        studentRepo.deleteById(id);
        return "Student successfully delete with this id  : "+ id;
    }
    public String updateStudentById(long id, Student updateStudent)
    {
        if (!studentRepo.existsById(id))
        {
            throw new ResourceNotFoundException("Student not found with this id: "+ id);
        }
        Student existingStudent = getStudentById(id);
        existingStudent.setBooks(updateStudent.getBooks());
        existingStudent.setName(updateStudent.getName());
        studentRepo.save(existingStudent);

        return "Successfully Update";
    }
}

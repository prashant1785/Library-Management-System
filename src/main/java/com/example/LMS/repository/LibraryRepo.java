package com.example.LMS.repository;

import com.example.LMS.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepo extends JpaRepository<Library, Long> {

    List<Library> findByBook(String book);
    List<Library> findByAuthor(String author);
    List<Library> findByStudent(String student);
    List<Library> findByStudentStudentId(Long studentId);
}

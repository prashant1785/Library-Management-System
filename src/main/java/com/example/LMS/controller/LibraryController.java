package com.example.LMS.controller;

import com.example.LMS.entity.Library;
import com.example.LMS.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @PostMapping("/addBook")
    public ResponseEntity<String> addBook(@RequestBody Library book) {
        try {
            return new ResponseEntity<>(libraryService.addBook(book), HttpStatus.CREATED);
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/getAllBooks")
    public ResponseEntity<List<Library>> getAllBooks() {
        try {
            return new ResponseEntity<>(libraryService.getAllBooks(),HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/getBookById/{id}")
    public ResponseEntity<Library> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(libraryService.getBookById(id));
    }
    @DeleteMapping("/deleteBookById/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable long id)
    {
        return ResponseEntity.ok(libraryService.deleteBookById(id));
    }
    @PutMapping("/updateBookById/{id}")
    public ResponseEntity<String> updateBookById(@PathVariable long id, @RequestBody Library book ) {
            return ResponseEntity.ok(libraryService.updateBookById(id, book));
    }
    @GetMapping("/findByBookName/{book}")
    public ResponseEntity<List<Library>> findByBookName(@PathVariable String book) {
        return ResponseEntity.ok(libraryService.getBooksByName(book));
    }
    @GetMapping("/findByAuthorName/{author}")
    public ResponseEntity<List<Library>> findByAuthorName(@PathVariable String author) {
        return ResponseEntity.ok(libraryService.getBooksByAuthor(author));
    }
    @GetMapping("/findByStudentName/{student}")
    public ResponseEntity<List<Library>> findByStudentName(@PathVariable String student) {
        return ResponseEntity.ok(libraryService.getBooksByStudent(student));
    }

    @GetMapping("/getCount")
    public ResponseEntity<?> getCount() {
        try {
            return ResponseEntity.ok(libraryService.getCount());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/getBooksByStudentId/{id}")
    public ResponseEntity<List<Library>> getBooksByStudentId(@PathVariable Long id) {
        return ResponseEntity.ok(libraryService.getBooksByStudentId(id));
    }
}

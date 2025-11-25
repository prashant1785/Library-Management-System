package com.example.LMS.service;

import com.example.LMS.entity.Library;
import com.example.LMS.exception.ResourceNotFoundException;
import com.example.LMS.repository.LibraryRepo;
import com.example.LMS.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepo libraryRepo;
    @Autowired
    private StudentRepo studentRepo;

    public String addBook(Library book){
         libraryRepo.save(book);
        return "Book Successfully Added";
    }
    public List<Library> getAllBooks()
    {
        return libraryRepo.findAll();
    }
    public Library getBookById(long id)
    {
        return libraryRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Book not found with this id: "+ id));
    }
    public String deleteBookById(long id)
    {
        if (!libraryRepo.existsById(id))
        {
            throw new ResourceNotFoundException("Book not found with this id: "+ id);
        }
        libraryRepo.deleteById(id);
        return "Book successfully delete with this id  : "+ id;
    }
    public String updateBookById(long id, Library updateBook)
    {
        if (!libraryRepo.existsById(id))
        {
            throw new ResourceNotFoundException("Book not found with this id: "+ id);
        }
        Library existingBook = getBookById(id);
        existingBook.setBook(updateBook.getBook());
        existingBook.setAuthor(updateBook.getAuthor());
        existingBook.setStudent(updateBook.getStudent());
        libraryRepo.save(existingBook);

        return "Successfully Update";
    }
    public List<Library> getBooksByName(String book) {
        return libraryRepo.findByBook(book);
    }
    public List<Library> getBooksByAuthor(String author) {
        return libraryRepo.findByAuthor(author);
    }
    public List<Library> getBooksByStudent(String student) {
        return libraryRepo.findByStudent(student);
    }
    public long getCount()
    {
        return libraryRepo.count();
    }
    public List<Library> getBooksByStudentId(Long studentId){
        if (!studentRepo.existsById(studentId))
        {
            throw new ResourceNotFoundException("Book not found with this student id: "+ studentId);
        }
        return libraryRepo.findByStudentStudentId(studentId);
    }
}

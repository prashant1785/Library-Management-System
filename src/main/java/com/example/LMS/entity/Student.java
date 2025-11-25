package com.example.LMS.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.print.Book;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long studentId;
    private String name;

    @OneToMany
    private List<Library> books;
}

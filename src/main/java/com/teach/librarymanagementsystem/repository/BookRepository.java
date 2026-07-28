package com.teach.librarymanagementsystem.repository;

import com.teach.librarymanagementsystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    // ==========================================
    // Search Book by Title (Case-Insensitive)
    // ==========================================
    List<Book> findByTitleEqualsIgnoreCase(String title);

    // ==========================================
    // Search Books by Category
    // ==========================================
    List<Book> findByCategoryEqualsIgnoreCase(String category);

    // ==========================================
    // Delete All Books by Category
    // ==========================================
    void deleteAllByCategoryEqualsIgnoreCase(String category);

}

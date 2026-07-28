package com.teach.librarymanagementsystem.repository;

import com.teach.librarymanagementsystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    // ==========================================
// Search Books by Title (Partial Match)
// ==========================================
    List<Book> findByTitleContainingIgnoreCase(String title);

    // ==========================================
// Search Books by Category (Partial Match)
// ==========================================
    List<Book> findByCategoryContainingIgnoreCase(String category);

    // ==========================================
// Delete All Books by Category (Exact Match)
// ==========================================
    void deleteAllByCategoryEqualsIgnoreCase(String category);

}

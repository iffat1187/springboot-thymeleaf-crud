package com.teach.librarymanagementsystem.repository;

import com.teach.librarymanagementsystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

}

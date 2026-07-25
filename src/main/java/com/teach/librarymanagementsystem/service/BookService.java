package com.teach.librarymanagementsystem.service;

import com.teach.librarymanagementsystem.entity.Book;

import java.util.List;

public interface BookService {

    Book saveBook(Book book);

    List<Book> getAllBooks();

    Book getBookById(Integer id);

    Book updateBook(Book book);

    void deleteBook(Integer id);

}
package com.teach.librarymanagementsystem.service;

import com.teach.librarymanagementsystem.entity.Book;
import com.teach.librarymanagementsystem.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    /*
     * Spring automatically injects BookRepository.
     *
     * We don't create the object manually.
     */
    private final BookRepository bookRepository;

    // ==========================================
    // Save Book
    // ==========================================

    @Override
    public Book saveBook(Book book) {

        return bookRepository.save(book);

    }

    // ==========================================
    // Get All Books
    // ==========================================

    @Override
    public List<Book> getAllBooks() {

        return bookRepository.findAll();

    }

    // ==========================================
    // Get Book By ID
    // ==========================================

    @Override
    public Book getBookById(Integer id) {

        return bookRepository.findById(id).orElse(null);

    }

    // ==========================================
    // Update Book
    // ==========================================

    @Override
    public Book updateBook(Book book) {

        return bookRepository.save(book);

    }

    // ==========================================
    // Delete Book
    // ==========================================

    @Override
    public void deleteBook(Integer id) {

        bookRepository.deleteById(id);

    }

    // ==========================================
// Search Books By Title
// ==========================================

    @Override
    public List<Book> searchByTitle(String title) {

        return bookRepository.findByTitleContainingIgnoreCase(title);

    }

    @Override
    public List<Book> searchByCategory(String category) {

        return bookRepository.findByCategoryContainingIgnoreCase(category);

    }


// ==========================================
// Delete Books By Category
// ==========================================

    @Override
    public void deleteBooksByCategory(String category) {

        bookRepository.deleteAllByCategoryEqualsIgnoreCase(category);

    }


}
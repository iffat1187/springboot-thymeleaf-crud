package com.teach.librarymanagementsystem.controller;

import com.teach.librarymanagementsystem.entity.Book;
import com.teach.librarymanagementsystem.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    /*
     * Spring injects BookService automatically.
     */
    private final BookService bookService;

    // ==========================================
    // Show Add Book Form
    // URL: http://localhost:8006/book/add
    // ==========================================

    @GetMapping("/add")
    public String showAddBookForm(Model model) {

        model.addAttribute("book", new Book());

        return "add-book";
    }

    // ==========================================
    // Save Book
    // ==========================================

    @PostMapping("/add")
    public String saveBook(@Valid @ModelAttribute Book book,
                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "add-book";
        }

        bookService.saveBook(book);

        return "redirect:/book/list";
    }

    // ==========================================
    // Show Book List
    // ==========================================

    @GetMapping("/list")
    public String showBookList(Model model) {

        model.addAttribute("books", bookService.getAllBooks());

        return "list-book";
    }

    @GetMapping("/edit/{id}")
    public String showEditBookForm(
            @PathVariable Integer id,
            Model model) {


        Book book = bookService.getBookById(id);

        model.addAttribute("book", book);

        return "edit-book";
    }

    @PostMapping("/update")
    public String updateBook(
            @Valid @ModelAttribute("book") Book book,
            BindingResult bindingResult) {


        if(bindingResult.hasErrors()) {

            return "edit-book";
        }


        bookService.updateBook(book);


        return "redirect:/book/list";
    }

    // Delete Book
// URL: /book/delete/{id}
// Example: /book/delete/5
// ==========================================

    @GetMapping("/delete/{id}")
    public String deleteBook(
            @PathVariable Integer id) {


        bookService.deleteBook(id);


        return "redirect:/book/list";
    }

    // ==========================================
// Search Books
// URL Example:
// /book/search?keyword=java
// ==========================================

    @GetMapping("/search")
    public String searchBooks(@RequestParam("keyword") String keyword,
                              Model model) {

        List<Book> books = bookService.searchByTitle(keyword);

        // If no books found by title,
        // search by category.
        if (books.isEmpty()) {

            books = bookService.searchByCategory(keyword);

        }

        model.addAttribute("books", books);

        return "list-book";

    }

    // ==========================================
// Delete Books By Category
// URL:
// /book/delete/category
// ==========================================

    // ==========================================
// Delete Books By Category
// ==========================================

    @PostMapping("/delete/category")
    public String deleteBooksByCategory(
            @RequestParam("category") String category) {


        bookService.deleteBooksByCategory(category);


        return "redirect:/book/list";

    }

}

package com.teach.librarymanagementsystem.controller;

import com.teach.librarymanagementsystem.entity.Book;
import com.teach.librarymanagementsystem.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

}

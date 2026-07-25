package com.teach.librarymanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {

    // ==========================================
    // Primary Key
    // ==========================================

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // ==========================================
    // Book Title
    // ==========================================

    @NotBlank(message = "Book title cannot be empty")
    @Size(min = 2, max = 100, message = "Title must be between 2 and 100 characters")
    private String title;

    // ==========================================
    // Author
    // ==========================================

    @NotBlank(message = "Author name cannot be empty")
    @Size(min = 2, max = 50, message = "Author name must be between 2 and 50 characters")
    private String author;

    // ==========================================
    // Category
    // ==========================================

    @NotBlank(message = "Category cannot be empty")
    private String category;

    // ==========================================
    // Publisher
    // ==========================================

    @NotBlank(message = "Publisher cannot be empty")
    private String publisher;

    // ==========================================
    // ISBN
    // ==========================================

    @NotBlank(message = "ISBN cannot be empty")
    @Size(min = 10, max = 20, message = "ISBN must be between 10 and 20 characters")
    private String isbn;

    // ==========================================
    // Language
    // ==========================================

    @NotBlank(message = "Language cannot be empty")
    private String language;

    // ==========================================
    // Published Year
    // ==========================================

    @Min(value = 1900, message = "Published year cannot be before 1900")
    @Max(value = 2100, message = "Published year is invalid")
    private Integer publishedYear;

    // ==========================================
    // Price
    // ==========================================

    @Positive(message = "Price must be greater than 0")
    private Double price;

    // ==========================================
    // Quantity
    // ==========================================

    @PositiveOrZero(message = "Quantity cannot be negative")
    private Integer quantity;
}

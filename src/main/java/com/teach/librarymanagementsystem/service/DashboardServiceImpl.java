package com.teach.librarymanagementsystem.service;


import com.teach.librarymanagementsystem.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {


    private final BookRepository bookRepository;



    // ==========================================
    // Total Number of Books
    // ==========================================

    @Override
    public long getTotalBooks() {

        return bookRepository.count();

    }



    // ==========================================
    // Total Quantity of Books
    // ==========================================

    @Override
    public Integer getTotalQuantity() {

        return bookRepository.findAll()
                .stream()
                .mapToInt(book -> book.getQuantity())
                .sum();

    }



    // ==========================================
    // Total Categories
    // ==========================================

    @Override
    public long getTotalCategories() {

        return bookRepository.findAll()
                .stream()
                .map(book -> book.getCategory())
                .distinct()
                .count();

    }



    // ==========================================
    // Total Inventory Value
    // price × quantity
    // ==========================================

    @Override
    public Double getTotalInventoryValue() {


        return bookRepository.findAll()
                .stream()
                .mapToDouble(
                        book -> book.getPrice() * book.getQuantity()
                )
                .sum();

    }

}
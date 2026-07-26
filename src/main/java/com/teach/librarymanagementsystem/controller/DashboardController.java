package com.teach.librarymanagementsystem.controller;


import com.teach.librarymanagementsystem.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class DashboardController {


    private final DashboardService dashboardService;



    // ==========================================
    // Show Dashboard
    // URL: /dashboard
    // ==========================================

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {


        model.addAttribute(
                "totalBooks",
                dashboardService.getTotalBooks()
        );


        model.addAttribute(
                "totalQuantity",
                dashboardService.getTotalQuantity()
        );


        model.addAttribute(
                "totalCategories",
                dashboardService.getTotalCategories()
        );


        model.addAttribute(
                "totalInventoryValue",
                dashboardService.getTotalInventoryValue()
        );


        return "dashboard";

    }

}

package com.truact.controller;

import com.truact.service.AdminService;
import com.truact.dto.AlertDto;
import com.truact.dto.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/configure")
    public String configureSystem(@RequestBody TransactionDto transactionDto) {
        if (transactionDto == null) {
            throw new IllegalArgumentException("TransactionDto cannot be null");
        }
        // Update system configuration based on input settings
        adminService.updateConfiguration(transactionDto);
        return "Configuration updated successfully.";
    }

    @GetMapping("/fraud-reports")
    public List<AlertDto> getFraudReports() {
        // Retrieve detailed reports on detected fraud cases
        return adminService.getFraudReports();
    }

    @PostMapping("/update-algorithm")
    public String updateAlgorithm(@RequestBody String performanceData) {
        if (performanceData == null || performanceData.trim().isEmpty()) {
            throw new IllegalArgumentException("Performance data cannot be null or empty");
        }
        // Update detection algorithms based on performance data
        boolean success = adminService.updateDetectionAlgorithm(performanceData);
        return success ? "Algorithm updated successfully." : "Failed to update algorithm.";
    }
}
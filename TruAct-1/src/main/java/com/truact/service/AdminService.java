package com.truact.service;

import com.truact.dao.FraudAlertDao;
import com.truact.dto.AlertDto;
import com.truact.dto.TransactionDto;
import com.truact.model.FraudAlert;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {

    private final FraudAlertDao fraudAlertDao;

    public AdminService(FraudAlertDao fraudAlertDao) {
        this.fraudAlertDao = fraudAlertDao;
    }

    // Method to configure detection settings
    public boolean configureDetectionSettings(double threshold, String algorithm) {
        // Logic to update detection settings in the database or application context
        // For now, we will just return true to indicate success
        return true;
    }

    // Method to monitor detected fraud cases
    public List<FraudAlert> monitorFraudCases() {
        return fraudAlertDao.getAllFraudAlerts();
    }

    // Method to update detection algorithms based on performance data
    public boolean updateDetectionAlgorithm(String algorithmName) {
        // Logic to update the detection algorithm
        // For now, we will just return true to indicate success
        return true;
    }

    public void updateConfiguration(TransactionDto transactionDto) {
        // Implement configuration update logic
    }

    public List<AlertDto> getFraudReports() {
        return fraudAlertDao.getAllFraudAlerts().stream()
            .map(f -> new AlertDto(f.getTransactionId(), String.valueOf(f.getUserId()), f.getAlertMessage(), f.isResolved()))
            .collect(Collectors.toList());
    }
}
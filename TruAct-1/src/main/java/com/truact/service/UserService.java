package com.truact.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truact.dao.FraudAlertDao;
import com.truact.dao.UserDao;
import com.truact.dto.AlertDto;
import com.truact.exception.ValidationException;
import com.truact.model.User;

@Service
public class UserService {

    private final UserDao userDao;
    private final FraudAlertDao fraudAlertDao;

    @Autowired
    public UserService(UserDao userDao, FraudAlertDao fraudAlertDao) {
        this.userDao = userDao;
        this.fraudAlertDao = fraudAlertDao;
    }

    /**
     * Monitors a transaction and checks for potential fraud.
     * 
     * @param alertDto The alert data containing transaction ID.
     * @return A list of alerts related to the transaction.
     * @throws ValidationException if the transaction ID is invalid.
     */
    public List<AlertDto> monitorTransaction(AlertDto alertDto) throws ValidationException {
        if (alertDto == null || alertDto.getTransactionId() == null || alertDto.getTransactionId().isEmpty()) {
            throw new ValidationException("Transaction ID cannot be null or empty.");
        }
        
        // Logic to monitor the transaction and generate alerts
        return userDao.getAlertsForTransaction(alertDto.getTransactionId());
    }

    public List<AlertDto> getTransactionAlerts() {
        return fraudAlertDao.getAllFraudAlerts().stream()
            .map(f -> new AlertDto(f.getTransactionId(), String.valueOf(f.getUserId()), f.getAlertMessage(), f.isResolved()))
            .collect(Collectors.toList());
    }

    /**
     * Retrieves user details based on user ID.
     * 
     * @param userId The ID of the user.
     * @return The user object containing user details.
     */
    public User getUserDetails(String userId) {
        try {
            return userDao.getUserById(Integer.parseInt(userId));
        } catch (RuntimeException e) {
            return null;
        }
    }

    // Additional user-related functionalities can be added here
}
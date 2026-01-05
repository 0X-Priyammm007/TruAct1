package com.truact.service;

import com.truact.dao.FraudAlertDao;
import com.truact.dao.TransactionDao;
import com.truact.dao.UserDao;
import com.truact.model.FraudAlert;
import com.truact.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
public class DetectionService {

    private final TransactionDao transactionDao;
    private final FraudAlertDao fraudAlertDao;
    private final UserDao userDao;

    @Autowired
    public DetectionService(TransactionDao transactionDao, FraudAlertDao fraudAlertDao, UserDao userDao) {
        this.transactionDao = transactionDao;
        this.fraudAlertDao = fraudAlertDao;
        this.userDao = userDao;
    }

    @Transactional
    public void processTransaction(Transaction transaction) {
        transactionDao.saveTransaction(transaction);
        boolean isFraudulent = detectFraud(transaction);
        
        if (isFraudulent) {
            FraudAlert alert = new FraudAlert(0, transaction.getTransactionId(), transaction.getUserId(), "Fraudulent transaction detected", false, new Timestamp(System.currentTimeMillis()));
            fraudAlertDao.saveFraudAlert(alert);
            userDao.incrementFraudCount(transaction.getUserId());
        }
    }

    private boolean detectFraud(Transaction transaction) {
        // Simple rule-based fraud detection
        // Flag as fraud if amount > 2000 or if transaction is from a user with high fraud count
        // For now, use amount threshold
        return transaction.getAmount().compareTo(java.math.BigDecimal.valueOf(2000)) > 0;
    }

    public List<FraudAlert> getAllFraudAlerts() {
        return fraudAlertDao.getAllFraudAlerts();
    }
}
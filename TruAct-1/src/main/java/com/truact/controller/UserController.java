package com.truact.controller;

import com.truact.dto.AlertDto;
import com.truact.dto.TransactionDto;
import com.truact.service.DetectionService;
import com.truact.service.UserService;
import com.truact.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final DetectionService detectionService;

    @Autowired
    public UserController(UserService userService, DetectionService detectionService) {
        this.userService = userService;
        this.detectionService = detectionService;
    }

    @PostMapping("/process-transaction")
    public String processTransaction(@RequestBody TransactionDto transactionDto) {
        Transaction transaction = new Transaction(0, transactionDto.getTransactionId(), transactionDto.getUserId(), transactionDto.getAmount(), transactionDto.getTimestamp(), transactionDto.getStatus());
        detectionService.processTransaction(transaction);
        return "Transaction processed";
    }

    @PostMapping("/transaction")
    public List<AlertDto> monitorTransaction(@RequestBody AlertDto alertDto) {
        return userService.monitorTransaction(alertDto);
    }

    @GetMapping("/alerts")
    public List<AlertDto> getTransactionAlerts() {
        return userService.getTransactionAlerts();
    }
}
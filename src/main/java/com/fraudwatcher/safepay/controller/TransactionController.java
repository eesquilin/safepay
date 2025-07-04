package com.fraudwatcher.safepay.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fraudwatcher.safepay.dto.TransactionRequestDTO;
import com.fraudwatcher.safepay.dto.TransactionResponseDTO;
import com.fraudwatcher.safepay.mapper.TransactionMapper;
import com.fraudwatcher.safepay.model.FraudCheckResult;
import com.fraudwatcher.safepay.model.Transaction;
import com.fraudwatcher.safepay.service.FraudCheckService;
import com.fraudwatcher.safepay.service.TransactionService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    final TransactionService transactionService;

    final FraudCheckService fraudCheckService;

    final TransactionMapper transactionMapper;

    TransactionController(TransactionService transactionService, FraudCheckService fraudCheckService,
            TransactionMapper transactionMapper) {
        this.transactionService = transactionService;
        this.fraudCheckService = fraudCheckService;
        this.transactionMapper = transactionMapper;
    }

    @PostMapping
    public ResponseEntity<TransactionResponseDTO> postTransaction(@Valid @RequestBody TransactionRequestDTO dto) {
        Transaction transaction = transactionMapper.toEntity(dto);
        Transaction createdTransaction = transactionService.createTransaction(transaction);
        TransactionResponseDTO responseDTO = transactionMapper.toResponseDto(createdTransaction);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public List<TransactionResponseDTO> getAllTransactions() {
        return transactionService.getAllTransactions().stream().map(transactionMapper::toResponseDto).toList();
    }

    @GetMapping("user/{userId}")
    public Page<TransactionResponseDTO> getTransactionByUserId(@PathVariable Long userId, Pageable pageable) {
        return transactionService.getTransactionByUserId(userId, pageable).map(transactionMapper::toResponseDto);
    }

    @GetMapping("{id}/fraud-check") // Method to check fraud result for an specific transaction.
    public ResponseEntity<FraudCheckResult> getFraudCheckByTransactionId(@PathVariable("id") Long transactionId) {
        FraudCheckResult fResult = fraudCheckService.evaluateTransaction(transactionId);
        return new ResponseEntity<>(fResult, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponseDTO> getTransactionById(@PathVariable("id") Long transactionId) {
        Transaction transaction = transactionService.getTransactionById(transactionId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction not found."));
        TransactionResponseDTO responseDTO = transactionMapper.toResponseDto(transaction);
        return ResponseEntity.ok(responseDTO);

    }

}

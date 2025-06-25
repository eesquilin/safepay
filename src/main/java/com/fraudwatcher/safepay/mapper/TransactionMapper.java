package com.fraudwatcher.safepay.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.fraudwatcher.safepay.dto.TransactionRequestDTO;
import com.fraudwatcher.safepay.dto.TransactionResponseDTO;
import com.fraudwatcher.safepay.model.Transaction;

@Component
public class TransactionMapper {

     public Transaction toEntity(TransactionRequestDTO dto){
        Transaction transaction = new Transaction();
        transaction.setUserId(dto.getUserId());
        transaction.setAmount(dto.getAmount());
        transaction.setType(dto.getType());
        transaction.setLocation(dto.getLocation());
        transaction.setMerchant(dto.getMerchant());
        transaction.setTimestamp(LocalDateTime.now());

        return transaction;
    }

    public TransactionResponseDTO toResponseDto(Transaction transaction){

        TransactionResponseDTO responseDTO = new TransactionResponseDTO();
        responseDTO.setId(transaction.getId());
        responseDTO.setUserId(transaction.getUserId());
        responseDTO.setAmount(transaction.getAmount());
        responseDTO.setTimestamp(transaction.getTimestamp());
        responseDTO.setType(transaction.getType());
        responseDTO.setLocation(transaction.getLocation());
        responseDTO.setMerchant(transaction.getMerchant());
        
        return responseDTO;

    }
    
}

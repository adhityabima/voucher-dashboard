package com.example.voucher_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RedeemResponseDto {
    private String code;
    private Double amount;
    private String message;
}

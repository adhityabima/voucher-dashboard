package com.example.voucher_service.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class VoucherDto {
    private Long id;
    private String code;
    private Double amount;
    private LocalDateTime expiryDate;
    private String voucherStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private VoucherCategoryDto voucherCategory;
}

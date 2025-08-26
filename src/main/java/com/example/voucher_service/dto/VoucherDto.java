package com.example.voucher_service.dto;

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
    private String expiryDate;
    private String couponStatus;
    private String createdAt;
    private String updatedAt;
}

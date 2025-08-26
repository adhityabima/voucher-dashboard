package com.example.voucher_service.dto;

import com.example.voucher_service.entity.enums.VoucherCategoryNameEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RedeemRequestDto {
    private Double amount;
    private VoucherCategoryNameEnum category;
}

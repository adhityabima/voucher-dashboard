package com.example.voucher_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VoucherCategoryDto {
    private Long id;
    private String name;
    private String description;
    private String createdAt;
    private String updatedAt;
    private Boolean isActive;
    private Long minimalAmount;
    private Long maximalAmount;
}

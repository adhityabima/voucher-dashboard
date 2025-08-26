package com.example.voucher_service.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.example.voucher_service.entity.enums.VoucherCategoryNameEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "voucher_category")
@NoArgsConstructor
@AllArgsConstructor
public class VoucherCategoryEntity {

    @Id
    @Column
    private Long id;

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private VoucherCategoryNameEnum name;

    @Column
    private String description;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private Boolean isActive;

    @Column(nullable = false)
    private Long minimalAmount;

    @Column(nullable = false)
    private Long maximalAmount;
}

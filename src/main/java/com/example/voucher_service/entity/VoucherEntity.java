package com.example.voucher_service.entity;
import java.time.LocalDateTime;

import com.example.voucher_service.entity.enums.VoucherStatusEnum;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "voucher")
@NoArgsConstructor
@AllArgsConstructor
public class VoucherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private LocalDateTime expiryDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VoucherStatusEnum couponStatus;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
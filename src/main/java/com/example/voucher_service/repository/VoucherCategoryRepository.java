package com.example.voucher_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.voucher_service.entity.VoucherCategoryEntity;

@Repository
public interface VoucherCategoryRepository extends JpaRepository<VoucherCategoryEntity, Long> {
    
}

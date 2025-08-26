package com.example.voucher_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.voucher_service.entity.VoucherEntity;

@Repository
public interface VoucherRepository extends JpaRepository<VoucherEntity, Long> {
    
}

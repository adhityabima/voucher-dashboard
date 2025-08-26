package com.example.voucher_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.voucher_service.entity.VoucherEntity;

@Repository
public interface VoucherRepository extends JpaRepository<VoucherEntity, Long> {
    
    @Query(value = "select v.*\r\n" + //
                "from voucher v\r\n" + //
                "inner join voucher_category vc on vc.id = v.voucher_category_id \r\n" + //
                "where vc.is_active is true\r\n" + //
                "and v.voucher_status = 'ACTIVE'\r\n" + //
                "and vc.minimal_amount <= :amount\r\n" + //
                "and vc.maximal_amount >= :amount\r\n" + //
                "and vc.name = :category\r\n" + //
                "order by v.created_at asc\r\n" + //
                "limit 1", nativeQuery = true)
    Optional<VoucherEntity> findRedeemableVoucher(@Param("category") String category, @Param("amount")  Double amount);
}

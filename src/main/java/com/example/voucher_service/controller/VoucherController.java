package com.example.voucher_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.voucher_service.dto.RedeemRequestDto;
import com.example.voucher_service.dto.RedeemResponseDto;
import com.example.voucher_service.dto.VoucherDto;
import com.example.voucher_service.service.VoucherService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/voucher-service/vouchers")
public class VoucherController {

    @Autowired
    private VoucherService voucherService;
    
    @GetMapping
    public ResponseEntity<Page<VoucherDto>> getAllVoucher(Pageable pageable) {
        Page<VoucherDto> response = voucherService.getAllVouchers(pageable);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VoucherDto> getVoucher(@PathVariable(value = "id") Long id) throws NotFoundException {
        VoucherDto response = voucherService.getVoucherDtoById(id);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<VoucherDto> createVoucher(@RequestBody VoucherDto body) throws NotFoundException {
        VoucherDto response = voucherService.createVoucher(body);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(201));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<VoucherDto> updateVoucher(@PathVariable(value = "id") Long id, @RequestBody VoucherDto body) throws NotFoundException {
        VoucherDto response = voucherService.updateVoucher(id, body);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(200));
    }  

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVoucher(@PathVariable(value = "id") Long id) throws NotFoundException {
        voucherService.deleteVoucher(id);
        return new ResponseEntity<>("Deleted", HttpStatusCode.valueOf(204));
    }

    @PostMapping("/redeem")
    public ResponseEntity<RedeemResponseDto> redeemVoucher(@RequestBody RedeemRequestDto dto) throws NotFoundException {
        RedeemResponseDto response = voucherService.redeemVoucher(dto);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(200));
    }
}

package com.example.voucher_dashboard.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoucherController {
    
    @GetMapping
    public ResponseEntity<String> getVoucher() {

        return new ResponseEntity<>("ok", HttpStatusCode.valueOf(200));

    }
}

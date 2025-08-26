package com.example.voucher_service.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.voucher_service.dto.VoucherDto;
import com.example.voucher_service.entity.VoucherEntity;
import com.example.voucher_service.repository.VoucherRepository;

import javassist.NotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VoucherService {

    @Autowired
    private VoucherRepository voucherRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<VoucherDto> getAllVouchers(Pageable pageable) {
        return voucherRepository.findAll(pageable).map(voucher -> modelMapper.map(voucher, VoucherDto.class));
    }

    public VoucherDto getVoucherDtoById(@PathVariable Long id) throws NotFoundException {
        VoucherEntity voucherEntity = this.getById(id);
        VoucherDto voucherDto = modelMapper.map(voucherEntity, VoucherDto.class);
        return voucherDto;
    }

    public VoucherDto createVoucher(VoucherDto voucherDto) {
        VoucherEntity voucherEntity = modelMapper.map(voucherDto, VoucherEntity.class);
        VoucherEntity savedEntity = voucherRepository.save(voucherEntity);
        return modelMapper.map(savedEntity, VoucherDto.class);
    }

    public VoucherDto updateVoucher(Long id, VoucherDto voucherDto) throws NotFoundException {
        VoucherEntity existingVoucher = this.getById(id);
        modelMapper.map(voucherDto, existingVoucher);
        VoucherEntity updatedVoucher = voucherRepository.save(existingVoucher);
        return modelMapper.map(updatedVoucher, VoucherDto.class);
    }

    public void deleteVoucher(Long id) throws NotFoundException {
        VoucherEntity existingVoucher = this.getById(id);
        voucherRepository.delete(existingVoucher);
    }

    public VoucherEntity getById(Long id) throws NotFoundException {
        return voucherRepository.findById(id).orElseThrow(() -> new NotFoundException("Voucher not found"));
    }
}

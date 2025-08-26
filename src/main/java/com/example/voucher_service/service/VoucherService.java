package com.example.voucher_service.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.voucher_service.dto.RedeemRequestDto;
import com.example.voucher_service.dto.RedeemResponseDto;
import com.example.voucher_service.dto.VoucherDto;
import com.example.voucher_service.entity.VoucherCategoryEntity;
import com.example.voucher_service.entity.VoucherEntity;
import com.example.voucher_service.entity.enums.VoucherStatusEnum;
import com.example.voucher_service.repository.VoucherCategoryRepository;
import com.example.voucher_service.repository.VoucherRepository;

import javassist.NotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VoucherService {

    @Autowired
    private VoucherRepository voucherRepository;

    @Autowired
    private VoucherCategoryRepository voucherCategoryRepository;

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

    public VoucherDto createVoucher(VoucherDto voucherDto) throws NotFoundException {
        VoucherEntity voucherEntity = modelMapper.map(voucherDto, VoucherEntity.class);
        VoucherCategoryEntity categoryEntity = this.getVoucherCategoryById(voucherDto.getVoucherCategory().getId());
        voucherEntity.setVoucherCategory(categoryEntity);
        voucherEntity = voucherRepository.save(voucherEntity);
        return modelMapper.map(voucherEntity, VoucherDto.class);
    }

    public VoucherDto updateVoucher(Long id, VoucherDto voucherDto) throws NotFoundException {
        voucherDto.setId(id);
        VoucherEntity voucherEntity = this.getById(id);
        modelMapper.map(voucherDto, voucherEntity);
        VoucherCategoryEntity categoryEntity = this.getVoucherCategoryById(voucherDto.getVoucherCategory().getId());
        voucherEntity.setVoucherCategory(categoryEntity);
        VoucherEntity updatedVoucher = voucherRepository.save(voucherEntity);
        return modelMapper.map(updatedVoucher, VoucherDto.class);
    }

    public void deleteVoucher(Long id) throws NotFoundException {
        VoucherEntity existingVoucher = this.getById(id);
        voucherRepository.delete(existingVoucher);
    }

    public RedeemResponseDto redeemVoucher(RedeemRequestDto dto) throws NotFoundException {
        VoucherEntity voucherEntity = voucherRepository.findRedeemableVoucher(dto.getCategory().name(), dto.getAmount())
            .orElseThrow(() -> new NotFoundException("No redeemable voucher not found"));
        
        voucherEntity.setVoucherStatus(VoucherStatusEnum.REDEEMED);
        VoucherEntity updatedVoucher = voucherRepository.save(voucherEntity);   
        return RedeemResponseDto.builder()
            .code(updatedVoucher.getCode())
            .amount(updatedVoucher.getAmount())
            .message("Voucher redeemed successfully")
            .build();
    }

    public VoucherEntity getById(Long id) throws NotFoundException {
        return voucherRepository.findById(id).orElseThrow(() -> new NotFoundException("Voucher not found"));
    }

    private VoucherCategoryEntity getVoucherCategoryById(Long id) throws NotFoundException {
        var hehe = voucherCategoryRepository.findById(id);
        System.out.println(hehe.toString());
        return voucherCategoryRepository.
                findById(id).orElseThrow(() -> new NotFoundException("Voucher Category not found"));
    }
}

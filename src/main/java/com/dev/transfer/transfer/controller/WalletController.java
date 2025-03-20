package com.dev.transfer.transfer.controller;

import com.dev.transfer.transfer.controller.dto.CreateWalletDto;
import com.dev.transfer.transfer.entity.Wallet;
import com.dev.transfer.transfer.service.WalletService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {
    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }


    @PostMapping("/wallets")
    public ResponseEntity<Wallet> createWallet(@RequestBody @Valid CreateWalletDto dto) {
        Wallet newWallet = walletService.createWallet(dto);

        return ResponseEntity.ok(newWallet);
    }
}

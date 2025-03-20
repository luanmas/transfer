package com.dev.transfer.transfer.service;

import com.dev.transfer.transfer.controller.dto.CreateWalletDto;
import com.dev.transfer.transfer.entity.Wallet;
import com.dev.transfer.transfer.exceptions.WalletDataAlreadyExistsException;
import com.dev.transfer.transfer.repository.WalletRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
public class WalletService {
    WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet createWallet(CreateWalletDto dto) {
        var walletDb = walletRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());

        if (walletDb.isPresent()) {
            throw new WalletDataAlreadyExistsException("CpfCnpj or Email already exists");
        }

        return walletRepository.save(dto.toWallet());
    }
}

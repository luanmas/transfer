package com.dev.transfer.transfer.controller.dto;

import com.dev.transfer.transfer.entity.Wallet;
import com.dev.transfer.transfer.entity.WalletType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateWalletDto(@NotBlank String fullName, @NotBlank String cpfCnpj, @NotBlank String password, @NotBlank String email, @NotNull WalletType.Enum walletType) {

    public Wallet toWallet() {
        return new Wallet (fullName, email, cpfCnpj, password, walletType);
    }
}

package com.dev.transfer.transfer.repository;

import com.dev.transfer.transfer.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Optional<Wallet> findByCpfCnpjOrEmail (String cpfCnpj, String email);
}

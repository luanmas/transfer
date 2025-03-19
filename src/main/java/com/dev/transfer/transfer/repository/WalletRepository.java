package com.dev.transfer.transfer.repository;

import com.dev.transfer.transfer.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}

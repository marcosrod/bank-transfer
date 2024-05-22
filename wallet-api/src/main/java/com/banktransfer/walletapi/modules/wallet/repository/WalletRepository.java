package com.banktransfer.walletapi.modules.wallet.repository;

import com.banktransfer.walletapi.modules.wallet.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
}

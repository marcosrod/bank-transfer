package com.banktransfer.walletapi.modules.wallet.service;

import com.banktransfer.walletapi.modules.wallet.dto.WalletRequest;
import com.banktransfer.walletapi.modules.wallet.dto.WalletResponse;
import com.banktransfer.walletapi.modules.wallet.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletService {

    private final WalletRepository repository;

    public WalletResponse save(WalletRequest request) {
        return null;
    }
}

package com.banktransfer.walletapi.modules.wallet.controller;

import com.banktransfer.walletapi.modules.wallet.dto.WalletRequest;
import com.banktransfer.walletapi.modules.wallet.dto.WalletResponse;
import com.banktransfer.walletapi.modules.wallet.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wallets")
@RequiredArgsConstructor
public class WalletController {

    private final WalletService service;

    @PostMapping
    public WalletResponse save(@RequestBody WalletRequest request) {
        return service.save(request);
    }
}

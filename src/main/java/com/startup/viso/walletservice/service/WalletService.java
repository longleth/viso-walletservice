package com.startup.viso.walletservice.service;

import com.startup.viso.walletservice.data.model.Wallet;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface WalletService {

    List<Wallet> getWallets();

    Wallet createWallet(Wallet wallet);

    Optional<Wallet> getWallet(String walletId);

    Wallet updateWallet(Wallet wallet, String walletId);

    void deleteWallet(String walletId);

}

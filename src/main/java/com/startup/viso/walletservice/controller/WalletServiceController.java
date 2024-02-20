package com.startup.viso.walletservice.controller;

import com.startup.viso.walletservice.data.model.Wallet;
import com.startup.viso.walletservice.service.WalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/wallets")
public class WalletServiceController {

    private static final Logger log = LoggerFactory.getLogger(WalletServiceController.class);

    private WalletService walletService;

    @Autowired
    public void setWalletService(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping
    public List<Wallet> getWallets() {
        log.info("Retrieving all wallets ...");
        return walletService.getWallets();
    }

    @PostMapping
    public Wallet createWallet(@RequestBody Wallet wallet) {
        log.info("Creating new wallet ..." + wallet.toString());
        return walletService.createWallet(wallet);
    }

    @GetMapping(value = "/{walletId}")
    public Optional<Wallet> getWallet(@PathVariable String walletId) {
        log.info("Retrieving wallet with ID: " + walletId);
        return walletService.getWallet(walletId);
    }

    @PutMapping(value = "/{walletId}")
    public Wallet updateWallet(@RequestBody Wallet wallet, @PathVariable String walletId) {
        log.info("Updating wallet [" + walletId + "] with new data" + wallet.toString());
        return walletService.updateWallet(wallet, walletId);
    }

    @DeleteMapping(value = "/{walletId}")
    public void deleteWallet(@PathVariable String walletId) {
        log.info("Deleting wallet with ID: " + walletId);
        walletService.deleteWallet(walletId);
    }

}

package com.startup.viso.walletservice.service;

import com.startup.viso.walletservice.data.model.Wallet;
import com.startup.viso.walletservice.data.repository.WalletRepository;
import com.startup.viso.walletservice.data.util.WalletCrudUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DefaultWalletService implements WalletService {

    private static final Logger log = LoggerFactory.getLogger(DefaultWalletService.class);

    private WalletRepository walletRepository;

    @Autowired
    public void setWalletRepository(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public List<Wallet> getWallets() {
        log.info("Loading all wallets from database ...");
        return walletRepository.findAll();
    }

    @Override
    public Wallet createWallet(Wallet wallet) {
        log.info("Inserting new wallet into database ..." + wallet.toString());
        wallet.setId(UUID.randomUUID().toString());
        return walletRepository.save(wallet);
    }

    @Override
    public Optional<Wallet> getWallet(String walletId) {
        log.info("Loading wallet record from database with ID: " + walletId);
        return walletRepository.findById(walletId);
    }

    @Override
    public Wallet updateWallet(Wallet wallet, String walletId) {
        log.info("Updating wallet [" + walletId + "] in database with new data" + wallet.toString());
        Wallet current = walletRepository.getReferenceById(walletId);
        WalletCrudUtil.update(current, wallet, (from, to) -> {
            if (!from.getAddress().equalsIgnoreCase(to.getAddress()))
                from.setAddress(to.getAddress());
            if (!from.getCurrencyId().equalsIgnoreCase(to.getCurrencyId()))
                from.setCurrencyId(to.getCurrencyId());
            if (!from.getUserId().equalsIgnoreCase(to.getUserId()))
                from.setUserId(to.getUserId());
        });
        return walletRepository.save(current);
    }

    @Override
    public void deleteWallet(String walletId) {
        log.info("Deleting wallet record in database with ID: " + walletId);
        walletRepository.deleteById(walletId);
    }

}

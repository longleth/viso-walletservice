package com.startup.viso.walletservice.data.repository;

import com.startup.viso.walletservice.data.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, String> {

    // TODO: create custom interface methods here

}

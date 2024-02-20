package com.startup.viso.walletservice.data.util;

import com.startup.viso.walletservice.data.model.Wallet;

public class WalletCrudUtil {

    public static void update(Wallet current, Wallet by,
                              AttributesUpdatable<Wallet> attributesUpdatable) {
        attributesUpdatable.updateIfChanged(current, by);
    }

}

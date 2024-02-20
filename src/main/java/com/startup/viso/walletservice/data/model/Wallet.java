package com.startup.viso.walletservice.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(schema = "public", name = "wallet")
public class Wallet implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "wallet_id", nullable = false)
    private String id;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "user_id", nullable = false)
    private String userId;
    @Column(name = "currency_id", nullable = false)
    private String currencyId;

    @Override
    public String toString() {
        return String.format("Wallet[id:%s, address:'%s', userId:'%s', currencyId:'%s']",
                id, address, userId, currencyId);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

}

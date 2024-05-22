package com.banktransfer.walletapi.modules.wallet.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "wallet")
public class Wallet {

    @Id
    @Column(name = "\"id\"")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wallet_id_seq")
    @SequenceGenerator(name = "wallet_id_seq", sequenceName = "wallet_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "fk_user")
    private Long userId;

    @Column(name = "amount")
    private Double amount;

    public Wallet(Long id, Long userId, Double amount) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
    }

    public Wallet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return Objects.equals(id, wallet.id) && Objects.equals(userId, wallet.userId) && Objects.equals(amount, wallet.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, amount);
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", userId=" + userId +
                ", amount=" + amount +
                '}';
    }
}

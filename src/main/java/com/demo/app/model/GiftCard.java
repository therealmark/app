package com.demo.app.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class GiftCard {
    private Long number;
    private Date expires;
    private Double balance;

    public GiftCard number(Long number) {
        this.number = number;
        return this;
    }

    public GiftCard expires(Date expires) {
        this.expires = expires;
        return  this;
    }

    public GiftCard balance(Double balance) {
        this.balance = balance;
        return  this;
    }
}

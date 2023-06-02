package com.demo.app.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Customer {
    private List<GiftCard> giftCards = new ArrayList<>();
    private String firstName;
    private String lastName;
    private String email;

    public Customer giftCards(List<GiftCard> giftCards) {
        this.giftCards = giftCards;
        return  this;
    }

    public Customer firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Customer lastName(String lastName) {
        this.lastName = lastName;
        return  this;
    }

    public Customer email(String email) {
        this.email = email;
        return this;
    }
}

package com.example.geektrust;

public class MetroCardBalance {
    private String cardNumber;
    private Integer balance;

    public MetroCardBalance(String cardNumber, Integer balance) {
        this.cardNumber = cardNumber;
        this.balance = balance;
    }

    public MetroCardBalance() {
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "MetroCardBalance{" +
                "cardNumber='" + cardNumber + '\'' +
                ", balance=" + balance +
                '}';
    }


}

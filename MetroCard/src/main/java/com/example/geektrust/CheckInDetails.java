package com.example.geektrust;

public class CheckInDetails {
    private String cardNumber;
    private String passengerType;
    private String originStation;

    public CheckInDetails(String cardNumber, String passengerType, String originStation) {
        this.cardNumber = cardNumber;
        this.passengerType = passengerType;
        this.originStation = originStation;
    }

    public CheckInDetails() {
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }

    public String getOriginStation() {
        return originStation;
    }

    public void setOriginStation(String originStation) {
        this.originStation = originStation;
    }

    @Override
    public String toString() {
        return "CheckInDetails{" +
                "cardNumber='" + cardNumber + '\'' +
                ", passengerType='" + passengerType + '\'' +
                ", originStation='" + originStation + '\'' +
                '}';
    }
}

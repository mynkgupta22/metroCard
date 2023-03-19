package com.example.geektrust;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculateStationWiseAmount {

    public List<Long> calculateResult(Map<String,MetroCardBalance> balanceRecord, List<CheckInDetails> checkInRecord){



        long totalDiscountCollectedAtCentral=0;
        long totalAmountCollectedAtCentral=0;
        long totalDiscountCollectedAtAirport=0;
        long totalAmountCollectedAtAirport=0;

        List<Long> tAList=new ArrayList<>();

        HashMap<String, String> trackingStation=new HashMap<>();

        for(int i=0;i<checkInRecord.size();i++){
            String cn=checkInRecord.get(i).getCardNumber();
            MetroCardBalance mcb=balanceRecord.get(cn);
            int ra=mcb.getBalance();
            CheckInDetails cd=checkInRecord.get(i);
            if(cd.getOriginStation().equals("CENTRAL")){


                if(cd.getPassengerType().equals("ADULT")){
                    if(trackingStation.containsKey(cd.getCardNumber())){
                        trackingStation.remove(cd.getCardNumber());
                        totalDiscountCollectedAtCentral += 100;
                        totalAmountCollectedAtCentral += countingCentral(balanceRecord,ra,cd.getCardNumber(),100);

                    }else {
                        trackingStation.put(cd.getCardNumber(),"CENTRAL");
                        totalAmountCollectedAtCentral += countingCentral(balanceRecord,ra,cd.getCardNumber(),200);

                    }
                }else if(cd.getPassengerType().equals("SENIOR_CITIZEN")){

                    if(trackingStation.containsKey(cd.getCardNumber())){
                        trackingStation.remove(cd.getCardNumber());
                        totalDiscountCollectedAtCentral += 50;
                        totalAmountCollectedAtCentral += countingCentral(balanceRecord,ra,cd.getCardNumber(),50);

                    }else {
                        trackingStation.put(cd.getCardNumber(),"CENTRAL");
                        totalAmountCollectedAtCentral += countingCentral(balanceRecord,ra,cd.getCardNumber(),100);
                    }

                }else{

                    if(trackingStation.containsKey(cd.getCardNumber())){
                        trackingStation.remove(cd.getCardNumber());
                        totalDiscountCollectedAtCentral += 25;
                        totalAmountCollectedAtCentral += countingCentral(balanceRecord,ra,cd.getCardNumber(),25);

                    }else {
                        trackingStation.put(cd.getCardNumber(),"CENTRAL");
                        totalAmountCollectedAtCentral += countingCentral(balanceRecord,ra,cd.getCardNumber(),50);
                    }
                }
            }else{
                if(cd.getPassengerType().equals("ADULT")){

                    if(trackingStation.containsKey(cd.getCardNumber())){
                        trackingStation.remove(cd.getCardNumber());

                        totalDiscountCollectedAtAirport += 100;
                        totalAmountCollectedAtAirport +=countingAirport(balanceRecord,ra,cd.getCardNumber(),100);
                    }else {
                        trackingStation.put(cd.getCardNumber(),"CENTRAL");
                        totalAmountCollectedAtAirport +=countingAirport(balanceRecord,ra,cd.getCardNumber(),200);
                    }
                }else if(cd.getPassengerType().equals("SENIOR_CITIZEN")){

                    if(trackingStation.containsKey(cd.getCardNumber())){
                        trackingStation.remove(cd.getCardNumber());
                        totalDiscountCollectedAtAirport += 50;
                        totalAmountCollectedAtAirport +=countingAirport(balanceRecord,ra,cd.getCardNumber(),50);

                    }else {
                        trackingStation.put(cd.getCardNumber(),"CENTRAL");
                        totalAmountCollectedAtAirport +=countingAirport(balanceRecord,ra,cd.getCardNumber(),100);
                    }

                }else{

                    if(trackingStation.containsKey(cd.getCardNumber())){
                        trackingStation.remove(cd.getCardNumber());
                        totalDiscountCollectedAtAirport += 25;
                        totalAmountCollectedAtAirport += countingAirport(balanceRecord,ra,cd.getCardNumber(),25);

                    }else {
                        trackingStation.put(cd.getCardNumber(),"CENTRAL");
                        totalAmountCollectedAtAirport += countingAirport(balanceRecord,ra,cd.getCardNumber(),50);
                    }
                }

            }
        }
        tAList.add(totalDiscountCollectedAtCentral);
        tAList.add(totalAmountCollectedAtCentral);
        tAList.add(totalDiscountCollectedAtAirport);
        tAList.add(totalAmountCollectedAtAirport);
        return tAList;

    }

    public long countingCentral(Map<String,MetroCardBalance>  balanceRecord,int ra,String cardNumber, int price){

        long totalAmountCollectedAtCentral=0;
        if(ra<price){
            balanceRecord.get(cardNumber).setBalance(0);
            balanceRecord.put(cardNumber,balanceRecord.get(cardNumber));
            int sca = ((price-ra)*2)/100;
            totalAmountCollectedAtCentral += sca+ra+(price-ra);

        }else{
            totalAmountCollectedAtCentral += price;
            balanceRecord.get(cardNumber).setBalance(ra-price);
            balanceRecord.put(cardNumber,balanceRecord.get(cardNumber));
        }
        return totalAmountCollectedAtCentral;
    }

    public  long countingAirport(Map<String,MetroCardBalance>  balanceRecord,int ra,String cardNumber, int price){


        long totalAmountCollectedAtAirport=0;
        if(ra<price){
            balanceRecord.get(cardNumber).setBalance(0);
            balanceRecord.put(cardNumber,balanceRecord.get(cardNumber));
            int sca = ((price-ra)*2)/100;
            totalAmountCollectedAtAirport += sca+ra+(price-ra);

        }else{
            totalAmountCollectedAtAirport += price;
            balanceRecord.get(cardNumber).setBalance(ra-price);
            balanceRecord.put(cardNumber,balanceRecord.get(cardNumber));
        }
        return totalAmountCollectedAtAirport;
    }
}

package com.example.geektrust;

import java.util.List;
import java.util.Map;

public class PrintTotalAmount {

    public void printAmount(Map<String,MetroCardBalance> balanceRecord, List<CheckInDetails> checkInRecord){

        CountingPassengers cp=new CountingPassengers();
        List<Map<String,Integer>> tc=cp.countingAllPassenger(checkInRecord);


        CalculateStationWiseAmount cswa=new CalculateStationWiseAmount();
        List<Long> tACList=cswa.calculateResult(balanceRecord,checkInRecord);

       System.out.println("TOTAL_COLLECTION CENTRAL "+tACList.get(1)+" "+tACList.get(0));
        System.out.println("PASSENGER_TYPE_SUMMARY");
        Map<String, Integer> map1= tc.get(0);
            for (Map.Entry<String, Integer> m : map1.entrySet()
            ) {
                System.out.println(m.getKey() + " " + m.getValue());
            }


        System.out.println("TOTAL_COLLECTION AIRPORT "+tACList.get(3)+" "+tACList.get(2));

        System.out.println("PASSENGER_TYPE_SUMMARY");
        Map<String, Integer> map2= tc.get(1);
        for (Map.Entry<String,Integer> m:map2.entrySet()
        ) {
            System.out.println(m.getKey()+" "+m.getValue());
        }

    }

    public PrintTotalAmount() {
    }

}

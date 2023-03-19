package com.example.geektrust;

import java.util.*;

public class CountingPassengers {

    public List<Map<String, Integer>> countingAllPassenger(List<CheckInDetails> checkInRecord) {

        List<Map<String, Integer>> totalCount = new ArrayList<>();

        Map<String, Integer> passengerCountAtCentral = new TreeMap<>();

        Map<String, Integer> passengerCountAtAirport = new TreeMap<>();

        for (int i = 0; i < checkInRecord.size(); i++) {
            CheckInDetails cid = checkInRecord.get(i);
            if (cid.getOriginStation().equals("CENTRAL")) {
                passengerCountAtCentral.put(cid.getPassengerType(), passengerCountAtCentral.getOrDefault(cid.getPassengerType(), 0) + 1);
            } else {
                passengerCountAtAirport.put(cid.getPassengerType(), passengerCountAtAirport.getOrDefault(cid.getPassengerType(), 0) + 1);
            }
        }
        sortedPassenger(passengerCountAtCentral);
        sortedPassenger(passengerCountAtAirport);
        totalCount.add(passengerCountAtCentral);
        totalCount.add(passengerCountAtAirport);
        return totalCount;

    }

    public void sortedPassenger(Map<String, Integer> map) {
        List<String> sortedPassengerTypes = new ArrayList<>(map.keySet());
        Collections.sort(sortedPassengerTypes, new Comparator<String>() {
            @Override
            public int compare(String type1, String type2) {
                int countDiff = map.get(type1) - map.get(type2);

                return countDiff;

            }
        });

    }
}

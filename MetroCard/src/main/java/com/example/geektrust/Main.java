package com.example.geektrust;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Main {


    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("input_file not found");
            return;
        }

        HashMap<String, MetroCardBalance> balanceRecord = new HashMap<>();

        List<CheckInDetails> checkInRecord = new ArrayList<>();

        //Sample code to read from file passed as command line argument
        try {
            //  the file to be opened for reading
           FileInputStream fis = new FileInputStream(args[0]);

            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read

            while (sc.hasNextLine()) {
                String type = sc.next();
                type = type.trim();


                switch (type) {
                    case "BALANCE":
                        String metroCardNum = sc.next();
                        int cardBalance = sc.nextInt();

                        MetroCardBalance mcb = new MetroCardBalance(metroCardNum, cardBalance);

                        balanceRecord.put(metroCardNum, mcb);
                        break;

                    case "CHECK_IN":
                        String metroCard = sc.next();

                        String passenger_type = sc.next();

                        String fromStation = sc.next();

                        CheckInDetails cid = new CheckInDetails(metroCard, passenger_type, fromStation);

                        checkInRecord.add(cid);

                        break;

                    case "PRINT_SUMMARY":


                        PrintTotalAmount cta = new PrintTotalAmount();
                        cta.printAmount(balanceRecord, checkInRecord);
                        break;

                }

            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
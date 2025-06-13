package com.ps;

import java.io.*;
import java.util.ArrayList;

public class ContractFileManager {

    public static void saveContract( Contract contract ){

        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("contracts.csv", true));

            if(contract instanceof SalesContract ){

                if (((SalesContract) contract).isFinance()){
                    String customerLine = String.format("%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%f|%f|%d|%d|%f|%s|%f",
                            "SALE",
                            contract.getCustomerName(),
                            contract.getCustomerEmail(),
                            contract.getVehicleSold().getVin(),
                            contract.getVehicleSold().getYear(),
                            contract.getVehicleSold().getMake(),
                            contract.getVehicleSold().getModel(),
                            contract.getVehicleSold().getVehicleType(),
                            contract.getVehicleSold().getColor(),
                            contract.getVehicleSold().getOdometer(),
                            contract.getVehicleSold().getPrice(),
                            ((SalesContract) contract).getSalesTaxAmount(),
                            ((SalesContract) contract).getRecordingFee(),
                            ((SalesContract) contract).getProcessingFee(),
                            contract.getTotalPrice(),
                            "YES",
                            contract.getMonthlyPayment());

                    bufferedWriter.write(customerLine);
                    bufferedWriter.newLine();

                } else {
                    String customerLine = String.format("%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%f|%f|%d|%d|%f|%s|%f",
                            "SALE",
                            contract.getCustomerName(),
                            contract.getCustomerEmail(),
                            contract.getVehicleSold().getVin(),
                            contract.getVehicleSold().getYear(),
                            contract.getVehicleSold().getMake(),
                            contract.getVehicleSold().getModel(),
                            contract.getVehicleSold().getVehicleType(),
                            contract.getVehicleSold().getColor(),
                            contract.getVehicleSold().getOdometer(),
                            contract.getVehicleSold().getPrice(),
                            ((SalesContract) contract).getSalesTaxAmount(),
                            ((SalesContract) contract).getRecordingFee(),
                            ((SalesContract) contract).getProcessingFee(),
                            contract.getTotalPrice(),
                            "NO",
                            contract.getMonthlyPayment());

                    bufferedWriter.write(customerLine);
                    bufferedWriter.newLine();
                }





            }else if( contract instanceof LeaseContract) {

                String customerLine = String.format("%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%f|%f|%f|%f|%f",
                        "LEASE",
                        contract.getCustomerName(),
                        contract.getCustomerEmail(),
                        contract.getVehicleSold().getVin(),
                        contract.getVehicleSold().getYear(),
                        contract.getVehicleSold().getMake(),
                        contract.getVehicleSold().getModel(),
                        contract.getVehicleSold().getVehicleType(),
                        contract.getVehicleSold().getColor(),
                        contract.getVehicleSold().getOdometer(),
                        contract.getVehicleSold().getPrice(),
                        ((LeaseContract) contract).getExpectedEndingValue(),
                        ((LeaseContract) contract).getLeaseFee(),
                        contract.getTotalPrice(),
                        contract.getMonthlyPayment());

                bufferedWriter.write(customerLine);
                bufferedWriter.newLine();

            }

            bufferedWriter.close();
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }




}

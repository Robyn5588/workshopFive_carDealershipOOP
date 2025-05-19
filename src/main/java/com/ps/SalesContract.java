package com.ps;

import java.util.ArrayList;

public class SalesContract extends Contract {

    private double salesTaxAmount;
    private int recordingFee;
    private int processingFee;
    private boolean finance;

    public SalesContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, int processingFee, boolean finance) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        salesTaxAmount = 0.05;
        recordingFee = 100;
        this.processingFee = processingFee;
        this.finance = finance;
    }



    @Override
    public double getTotalPrice(){


        double totalPrice;

        double originalPrice = getVehicleSold().getPrice();

        salesTaxAmount *= originalPrice;



        return totalPrice = salesTaxAmount + recordingFee + processingFee + originalPrice;
    }

    @Override
    public double getMonthlyPayment(){
        return 0;
    }

    public int getProccesingFee(){

//        if(originalPrice < 10000){
//            processingFee = 295;
//        }else processingFee = 495;
//
        return 0; // processingFee;
    }

    public boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }

    public int getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(int processingFee) {
        this.processingFee = processingFee;
    }

    public int getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(int recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }
}

package com.ps;

import java.util.ArrayList;

public class SalesContract extends Contract {

    private double salesTaxAmount;
    private int recordingFee;
    private int processingFee;
    private boolean finance;

    public SalesContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, int processingFee, boolean finance) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        salesTaxAmount = 0.05 * getVehicleSold().getPrice();
        recordingFee = 100;
        this.processingFee = processingFee;
        this.finance = finance;
    }



    @Override
    public double getTotalPrice(){

        double totalPrice;

        return totalPrice = salesTaxAmount + recordingFee + processingFee + originalPrice();
    }

    @Override
    public double getMonthlyPayment(){

        double interest;
        int months;

        if (finance){
            if(originalPrice() >= 10_000 ) {
                interest = 0.0425;
                months = 48;
            }else{
                interest = 0.0525;
                months = 24;

            }

            double moInterestRate = (interest/100) / 12;

            double loanAmount = getTotalPrice();

            double numerator = moInterestRate * Math.pow((1+moInterestRate), months);

            double denominator = Math.pow((1+moInterestRate),(months-1));

            double moPayment = loanAmount * numerator/denominator;

            return moPayment;

        }else{

            return 0;
        }

    }

    public double originalPrice(){
        return getVehicleSold().getPrice();
    }


    public boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }

    public int getProcessingFee() {
        double originalPrice = getVehicleSold().getPrice();

        if(originalPrice < 10000){
            processingFee = 295;
        }else processingFee = 495;

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

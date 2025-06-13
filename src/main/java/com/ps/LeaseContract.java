package com.ps;

public class LeaseContract extends Contract {

    private double expectedEndingValue;
    private double leaseFee;

    public LeaseContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.expectedEndingValue = 0.5 * getVehicleSold().getPrice() ;
        this.leaseFee = 0.07 * getVehicleSold().getPrice();
    }

    @Override
    public double getTotalPrice(){

        return leaseFee + expectedEndingValue;
    }

    @Override
    public  double getMonthlyPayment(){

        double interest = .04;
        int months = 36;
        double price = getTotalPrice();

        double depreciation = price - expectedEndingValue;
        double moneyFactor = interest / 12;
        double moInterest = (price + expectedEndingValue) * moneyFactor;
        double basePayment = (depreciation/months) + moInterest;
        double moLeaseFee = leaseFee /months;

        return basePayment + moLeaseFee;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }
}
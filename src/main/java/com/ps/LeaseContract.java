package com.ps;

public class LeaseContract extends Contract {

    private float expectedEndingValue;
    private float leaseFee;

    public LeaseContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, float leaseFee, float expectedEndingValue) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.leaseFee = leaseFee;
        this.expectedEndingValue = expectedEndingValue;
    }

    @Override
    public double getTotalPrice(){
        return 0;
    }

    @Override
    public  double getMonthlyPayment(){
        return 0;
    }

    public float getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(float expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public float getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(float leaseFee) {
        this.leaseFee = leaseFee;
    }
}

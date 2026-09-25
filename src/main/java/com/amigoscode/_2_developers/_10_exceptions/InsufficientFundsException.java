package com.amigoscode._2_developers._10_exceptions;

public class InsufficientFundsException extends Exception {

    private final double amount;

    public InsufficientFundsException(String message, double amount) {
        this.amount = amount;
        super(message);
    }

    public double getAmount() {
        return amount;
    }
}

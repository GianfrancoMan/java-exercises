package com.amigoscode._2_developers._5_methods;

public class PropertyRentalYield {
    static void main() {
        System.out.println( "Your Rental Yield is: " + PropertyRentalYield.getRentalYield(250000, 1300));
    }

    static double getRentalYield(double propertyPrice, double rentalIncome) {
        double annualRental = rentalIncome * 12;
        return annualRental / propertyPrice * 100;
    }
}

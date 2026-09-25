package com.amigoscode._2_developers._10_exceptions;

/**
 * Custom Exception Exercises
 *
 * Practice creating custom checked and unchecked exceptions, throwing them
 * from methods, catching them, and using exception chaining.
 */
public class CustomException {

    // TODO: 1 - Create a custom CHECKED exception class called InsufficientFundsException.
    //  It should:
    //  - Extend Exception (making it a checked exception)
    //  - Have a private final double 'amount' field (the amount that was short)
    //  - Have a constructor that takes a String message and double amount,
    //    calls super(message), and stores the amount
    //  - Have a getter: double getAmount()
    //  Define it as a static inner class here, or as a separate class in this package.
    //I create a separate Java class in the src/main/java/com/developeres/exceptions/InsufficientFundsException.java file.


    // TODO: 2 - Create a custom UNCHECKED exception class called InvalidAgeException.
    //  It should:
    //  - Extend RuntimeException (making it an unchecked exception)
    //  - Have a constructor that takes a String message and calls super(message)
    //  - Have a constructor that takes a String message and a Throwable cause,
    //    and calls super(message, cause)
    //  Define it as a static inner class here.
    public static class InvalidAgeException extends RuntimeException {
        public InvalidAgeException(String message) {
            super(message);
        }

        public InvalidAgeException(String message, Throwable cause) {
            super(message, cause);
        }
    }


    // TODO: 3 - Create a static inner class BankAccount with:
    //  - A private double 'balance' field
    //  - A constructor that takes an initial balance
    //  - A method: void withdraw(double amount) throws InsufficientFundsException
    //    If amount > balance, throw new InsufficientFundsException with an appropriate
    //    message and the shortfall amount (amount - balance).
    //    Otherwise, subtract amount from balance.
    //  - A method: double getBalance()
    public static class BankAccount {
        private double balance;

        public BankAccount(double balance) {
            this.balance = balance;
        }

        public void withdraw(double amount) throws InsufficientFundsException {
            if(amount > balance) {
                throw new InsufficientFundsException("Insufficient funds", (amount-balance));
            }
            balance -= amount;
        }

        public double getBalance() {
            return balance;
        }
    }


    // TODO: 4 - Create a static method: void validateAge(int age)
    //  If age < 0 or age > 150, throw a new InvalidAgeException with an appropriate message.
    //  Otherwise, print "Age " + age + " is valid."
    public static void validateAge(int age) throws InvalidAgeException {
        if(age < 0 || age > 150) {
            throw new InvalidAgeException("Age " + age + " is invalid.");
        }
        System.out.println("Age " + age + " is valid.");
    }


    public static void main(String[] args) {
        System.out.println("=== Custom Checked Exception (InsufficientFundsException) ===");
        // TODO: 5 - Create a BankAccount with balance 100.
        //  Try to withdraw 50 (should succeed, print remaining balance).
        //  Try to withdraw 75 (should throw InsufficientFundsException).
        //  Catch the exception and print its message and the shortage amount.
        //  Also try validateAge with valid (25) and invalid (-5) values,
        //  catching InvalidAgeException.
        BankAccount account = new BankAccount(100);
        try {
            account.withdraw(50);
            account.withdraw(75);
        } catch (InsufficientFundsException e) {
            System.out.println("Message:" + e.getMessage() + " short amount:" + e.getAmount());
        }

        try {
            validateAge(25);
            validateAge(-5);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage() + e.getCause());
        }


        System.out.println("\n=== Exception Chaining ===");
        // TODO: 6 - Demonstrate exception chaining:
        //  In a try block, parse an invalid string like "abc" with Integer.parseInt().
        //  In the catch block for NumberFormatException, create a new InvalidAgeException
        //  with the original exception as the cause (using the two-arg constructor
        //  or initCause()). Throw the new exception.
        //  In an outer try-catch, catch the InvalidAgeException and print:
        //  - The exception message
        //  - The cause (using getCause())
        try {
            try {
                Integer.parseInt("asd");
            } catch (NumberFormatException e) {
                throw new InvalidAgeException("Invalid age", e);
            }
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage() + e.getCause());
        }
    }
}

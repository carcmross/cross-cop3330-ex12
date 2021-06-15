package base;

import java.util.Scanner;

/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Marc-Anthony Cross
 */

/*
 * Computing simple interest is a great way to quickly figure out whether an investment has value. It’s also a good
 * way to get comfortable with explicitly coding the order of operations in your programs.
 *
 * Create a program that computes simple interest. Prompt for the principal amount, the rate as a percentage,
 * and the time, and display the amount accrued (principal + interest).
 *
 * The formula for simple interest is A = P(1 + rt), where P is the principal amount, r is the annual rate of interest,
 * t is the number of years the amount is invested, and A is the amount at the end of the investment.
 * Example Output
 *
 * Enter the principal: 1500
 * Enter the rate of interest: 4.3
 * Enter the number of years: 4
 * After 4 years at 4.3%, the investment will be worth $1758.
 *
 * Constraints
 *
 *     Prompt for the rate as a percentage (like 15, not .15). Divide the input by 100 in your program.
 *     Ensure that fractions of a cent are rounded up to the next penny.
 *     Ensure that the output is formatted as money.
 *
 * Challenges
 *
 *     Ensure that the values entered for principal, rate, and number of years are numeric and that the program will
 *     not let the user proceed without valid inputs.
 *     Alter the program to use a function called calculateSimpleInterest that takes in the rate, principal,
 *     and number of years and returns the amount at the end of the investment.
 *     In addition to printing out the final amount, print out the amount at the end of each year.
 *
 */
public class App {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();
        String principal = myApp.getPrincipal();
        String rate = myApp.getInterestRate();
        String decimal_rate = myApp.convertToDecimal(rate);
        String num_years = myApp.getNumYears();
        String finalamt = myApp.calcEndAmt(principal, decimal_rate, num_years);
        String outputString = myApp.generateOutput(num_years, rate, finalamt);
        myApp.printOutput(outputString);
    }

    private void printOutput(String outputString) {
        System.out.println(outputString);
    }

    private String generateOutput(String num_years, String rate, String finalamt) {
        return String.format("After %d years at %.1f%%, the investment will be worth $%.2f.",
                                Integer.parseInt(num_years), Double.parseDouble(rate), Double.parseDouble(finalamt));
    }

    private String getPrincipal() {
        System.out.print("Enter the principal: ");
        return in.nextLine();
    }

    private String getInterestRate() {
        System.out.print("Enter the rate of interest: ");
        return in.nextLine();
    }

    private String convertToDecimal(String rate) {
        double decimal = Double.parseDouble(rate) / 100;
        return String.valueOf(decimal);
    }

    private String getNumYears() {
        System.out.print("Enter the number of years: ");
        return in.nextLine();
    }

    private String calcEndAmt(String principal, String percent_rate, String num_years) {
        double finalamt = (1 + (Double.parseDouble(percent_rate) * Integer.parseInt(num_years))) *
                            Double.parseDouble(principal);
        finalamt = Math.ceil(finalamt * 100) / 100;
        return String.valueOf(finalamt);
    }
}

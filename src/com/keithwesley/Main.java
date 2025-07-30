package com.keithwesley;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        long principalAmount = scanner.nextLong();
        System.out.print("Annual Interest Rate: ");
        float aInterest = scanner.nextFloat();
        System.out.print("Period (Years): ");
        byte periodYears = scanner.nextByte();

        scanner.close();

        final byte MONTHS = 12;
        final byte PERCENT = 100;
        float monthlyInterest = aInterest / MONTHS / PERCENT;
        int payments = periodYears * MONTHS;

        double mortage = principalAmount * (monthlyInterest * Math.pow(1 + monthlyInterest, payments))
                / (Math.pow(1 + monthlyInterest, payments) - 1);

        NumberFormat addDollars = NumberFormat.getCurrencyInstance(Locale.US);
        String formatted = addDollars.format(mortage);

        System.out.println("Your Mortage is: " + formatted);
    }
}
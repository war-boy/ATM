package com.java_atm;

import java.io.Console;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("This is the ATM");

        boolean correct_creds = false;

        float balance = 0.0F;

        String user_name = "";

        String pin = "";

        for (int i = 1; i <= 3 && !correct_creds; i++) {

            System.out.println("Please enter your user name:");

            user_name = scanner.nextLine().trim();

            System.out.println("Please enter your pin:");

            pin = scanner.nextLine().trim();

            //ignores capital. returns boolean

            if (user_name.equalsIgnoreCase("dcooper") && pin.equalsIgnoreCase("1234")) {
                correct_creds = true;
            }
        }

        boolean running = true;

        while (running && correct_creds) {

            System.out.println("Please Choose an Option Below\nD: Deposit\nW: Withdraw\nI: Information\nE: Escape");
            String user_input = scanner.nextLine().toLowerCase();

            switch (user_input) {
                case "d":
                case "deposit":
                    System.out.print("How much are you depositing?: ");
                    float deposit_amount = Float.parseFloat(scanner.nextLine());

                    balance += deposit_amount;

                    //.02F a float with two decimals
                    System.out.println(String.format("%.02f has been deposited into your account. Your balance is now %.02f", deposit_amount, balance));

                    break;

                case "w":
                case "withdraw":
                    System.out.println("How much do you want to withdraw?: ");

                    float withdraw_amount = Float.parseFloat(scanner.nextLine());

                    if ((balance - withdraw_amount) < 0){
                        System.out.println("Insufficient funds. Please try again");
                    }
                    else{
                        balance -= withdraw_amount;
                        System.out.println(String.format("%.02f has been withdrawn from your account. Your balance is now %.02f", withdraw_amount, balance));
                    }

                    break;

                case "i":
                case "information":
                    System.out.println(String.format("User Name: %s\nPin: %s\nAccount Balance:%.02f", user_name, pin, balance ));

                    break;

                case "e":
                case "exit":
                case "x":
                    running = false;
                    continue;//ends switch and checks loop condition.

                default:
                    System.out.println("Invalid input. PLease try again.");
                    break;
            }

            //console.flush(); clears out threads, not contents of console.
            //There is no console.clear equiv

            System.out.println("Would you like to perform another action? Type yes/no:");

            String user_answer = scanner.nextLine().trim();

            if (user_answer.equalsIgnoreCase("no")) {
                running = false;
            }

        }

        //Takes up memory/resources
        scanner.close();

        System.out.println("Thank you for using the ATM and for your money.");

    }
}

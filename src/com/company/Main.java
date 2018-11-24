package com.company;

import java.util.Scanner;

public class Main {

    static int []arr;
    static int size;

    public static void main(String[] args) {

        System.out.print("Enter The Size of the Array: ");
        Scanner scanner = new Scanner(System.in);
        size = scanner.nextInt();
        System.out.println("Enter "+size+" Integers");
        arr = new int[size];
        for ( int i=0;i<size;i++){
            arr[i] = scanner.nextInt();
        }
        printMenu();
        int choice = scanner.nextInt();
        switch (choice)
        {
            // Add Your Function case and call it
            case 1:
                break;
            case 18: // Execute All
                // Add Your Function Here
                break;
        }

    }

    private static void printMenu() {

        System.out.println("Choose the number of operation you want to make:");
        System.out.println("1-\tMost repeated value");
        System.out.println("2-\tSort");
        System.out.println("3-\tShuffle");
        System.out.println("4-\tFind the largest prime");
        System.out.println("5-\tFind the smallest prime");
        System.out.println("6-\tCheck palindrome");
        System.out.println("7-\tCheck sorted");
        System.out.println("8-\tCount primes");
        System.out.println("9-\tReverse array");
        System.out.println("10-\tShift array");
        System.out.println("11-\tDistinct array");
        System.out.println("12-\tGet the maximum 3 numbers");
        System.out.println("13-\t Get the minimum 3 numbers");
        System.out.println("14-\tGet average");
        System.out.println("15-\tGet median");
        System.out.println("16-\tReturn only primes");
        System.out.println("17-\tZero if less than zero");
        System.out.println("18-\tExecute All");

    }
}

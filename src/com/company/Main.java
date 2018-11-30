package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int []arr;
    static String inputString;
    static int size;
    static boolean isString = false;   // false = integer, true = string

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter The number of the input type:\n1- String\n2- Integer");
        int type = scanner.nextInt();
        if ( type == 1 ){
            isString=true;
        }

        System.out.print("Enter The Size of the Array: ");
        size = scanner.nextInt();
        System.out.println("Enter "+size+" Elements of the array");
        if ( isString ) { // if input is string
            scanner.nextLine();
            inputString = scanner.nextLine();
        }
        else {  // if input is integer
            arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = scanner.nextInt();
            }
        }
        printMenu();
        int choice = scanner.nextInt();
        switch (choice)
        {
            // Add Your Function case and call it
            case 1:
                break;
            case 13:
                get_TheMin_3Numbers();
                break;
            case 17:
                zeroIfNegative();
                break;
            case 18: // Execute All
                // Add Your Function Here
                get_TheMin_3Numbers();
                zeroIfNegative();
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

    private static void zeroIfNegative()
    {
        System.out.println("Zero If Less Than Negative");
        if ( isString ){
            System.out.print(inputString);
            System.out.println("\n=======================================");
            return;
        }
        for ( int i=0;i<size;i++){
            System.out.print(arr[i]<0?0:arr[i]+" ");
        }
        System.out.println("\n=======================================");
    }

    private static void  get_TheMin_3Numbers()
    {
        if ( isString ){
            System.out.println("Get The Minimum 3 Numbers!!");
            System.out.print("Can't Works With String");
            System.out.println("\n=======================================");
            return;
        }
        if(arr.length < 3)
        {
            System.out.println("Get The Minimum 3 Numbers!!");
            System.out.print("Can't Works on less than 3 numbers");
            System.out.println("\n=======================================");
            return;
        }

        int[]arr1 = new int[arr.length];
        for(int i = 0; i < arr.length; i++)
        {
            arr1[i] = arr[i];
        }
        Arrays.sort(arr1);
        System.out.print("The Minimum 3 Numbers: ");
        for(int i = 0; i < 3; i++)
        {
            System.out.print(arr1[i] + " ");
        }
        System.out.println("\n=======================================");
    }
}

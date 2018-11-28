package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map.Entry;

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


        if ( isString ) { // if input is string
            System.out.println("Enter Your String Without Spaces");
            scanner.nextLine();
            inputString = scanner.nextLine();
            size=inputString.length();
        }
        else {  // if input is integer
            try {
                System.out.print("Enter The Size of the Array: ");
                size = scanner.nextInt();
                System.out.println("Enter "+size+" Elements of the array");
                arr = new int[size];
                for (int i = 0; i < size; i++) {
                    arr[i] = scanner.nextInt();
                }
            } catch (InputMismatchException e){
                System.out.println("You Said You will enter Integers -_-");
                System.exit(1);
            }

        }
        printMenu();
        int choice = scanner.nextInt();
        switch (choice)
        {
            // Add Your Function case and call it
            case 1:
                mostRepeatedValue();
                break;
            case 17:
                zeroIfNegative();
                break;
            case 18: // Execute All
                // Add Your Function Here
                mostRepeatedValue();
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
    private static char[] intTochar(int[] a)
    {
       StringBuilder builder = new StringBuilder();
        for(int i : a)
        {
            builder.append(i);
        }
    return builder.toString().toCharArray();
    }
    private static void mostRepeatedValue() {
        System.out.println("Most Repeated Value");
        char[] array = null;
        if(isString)
        {
             array = inputString.toCharArray();
        }
        else
        {
            array = intTochar(arr);
        }
        HashMap<Character, Integer> m = new HashMap<>();
        for(char c : array)
        {
            if(m.containsKey(c))
            {
                m.put(c,m.get(c)+1);
            }else
            {
                m.put(c, 1);
            }
        }
        int freq = 0;
        Character c_freq = null;
        for (Entry<Character, Integer> val : m.entrySet()) {
            if (freq < val.getValue())
            {
                c_freq = val.getKey();
                freq = val.getValue();
            }
        }
        System.out.println(c_freq);
        System.out.println("\n=======================================");
    }
}

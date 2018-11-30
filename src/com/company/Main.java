package com.company;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {


    static int[] arr;
    static String inputString;
    static int size;
    static boolean isString = false;   // false = integer, true = string

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter The number of the input type:\n1- String\n2- Integer");
        int type = scanner.nextInt();
        if (type == 1) {
            isString = true;
        }

        if (isString) { // if input is string
            System.out.println("Enter Your String Without Spaces");
            scanner.nextLine();
            inputString = scanner.nextLine();
            size = inputString.length();
        } else {  // if input is integer
            try {
                System.out.print("Enter The Size of the Array: ");
                size = scanner.nextInt();
                System.out.println("Enter " + size + " Elements of the array");
                arr = new int[size];
                for (int i = 0; i < size; i++) {
                    arr[i] = scanner.nextInt();
                }
            } catch (InputMismatchException e) {
                System.out.println("You Said You will enter Integers -_-");
                System.exit(1);
            }

        }
        printMenu();
        int choice = scanner.nextInt();
        switch (choice) {
            // Add Your Function case and call it
            case 1:
                mostRepeatedValue();
                break;
            case 5:
                GetSmallestPrime();
                break;
            case 7:
                printCheckSorted();
                break;

            case 9:
                reverseArray();
                break;
            case 15:
                getMedian();
                break;
            case 17:
                zeroIfNegative();
                break;
            case 4:
            	find_Largest_prime();
            	break;
            case 8:
                countPrime();
                break;
            case 14:
                getAverage();
                break;
            case 18: // Execute All
                // Add Your Function Here
                find_Largest_prime();
                reverseArray();
                printCheckSorted();
                mostRepeatedValue();
                zeroIfNegative();
                countPrime();
		getMedian();

                GetSmallestPrime();

                getAverage();

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

    private static void zeroIfNegative() {
        System.out.println("Zero If Less Than Negative");
        if (isString) {
            System.out.print(inputString);
            System.out.println("\n=======================================");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] < 0 ? 0 : arr[i] + " ");
        }
        System.out.println("\n=======================================");
    }

    /**
     * Counts the number of primes in the global array arr.
     */
    private static void countPrime() {
        System.out.println("Primes Count");

        boolean prime = true;
        int count = 0;
        if (isString) {
            System.out.print("Error: There is no prime character ");
            System.out.println("\n=======================================");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            prime = true;
            if (arr[i] == 0 || arr[i] == 1)
                prime = false;
            else {
                for (int j = 2; j <= arr[i] / 2; j++) {
                    if (arr[i] % j == 0) {
                        prime = false;
                        break;
                    }
                }
                if (prime) {
                    count++;
                }
            }
        }
        System.out.println("The number of prime numbers in this array:  " + count);
        System.out.println("=======================================");
    }

    private static char[] intTochar(int[] a) {
        StringBuilder builder = new StringBuilder();
        for (int i : a) {
            builder.append(i);
        }
        return builder.toString().toCharArray();
    }

    private static void mostRepeatedValue() {
        System.out.println("Most Repeated Value");
        char[] array = null;
        if (isString) {
            array = inputString.toCharArray();
        } else {
            array = intTochar(arr);
        }
        HashMap<Character, Integer> m = new HashMap<>();
        for (char c : array) {
            if (m.containsKey(c)) {
                m.put(c, m.get(c) + 1);
            } else {
                m.put(c, 1);
            }
        }
        int freq = 0;
        Character c_freq = null;
        for (Entry<Character, Integer> val : m.entrySet()) {
            if (freq < val.getValue()) {
                c_freq = val.getKey();
                freq = val.getValue();
            }
        }
        System.out.println(c_freq);
        System.out.println("\n=======================================");
    }

    public static void GetSmallestPrime() {
        System.out.println("Finding Smallest Prime ");

        if (isString) {
            System.out.println("The function finding smallest prime doesn't work on strings");
            System.out.println("\n=======================================");
            return;
        }
        ArrayList<Integer> primes = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            if (arr[i] == 0 || arr[i] == 1 || arr[i] == 4) {
                flag = true;

            }

            for (int j = 2; j < arr[i] / 2; j++) {
                if (arr[i] % j == 0) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                primes.add(arr[i]);
            }
        }
        if (primes.isEmpty()) {
            System.out.println("There is no prime numbers");
            System.out.println("\n=======================================");

        } else {
            int minValue = primes.get(0);
            int indexx = 0;
            for (int i = 1; i < primes.size(); i++) {
                if (primes.get(i) < minValue) {
                    minValue = primes.get(i);
                    indexx = i;
                }
            }

            System.out.println(primes.get(indexx));
            System.out.println("\n=======================================");
        }
    }


    private static void getAverage() {
        System.out.println("Get Average\n=======================================");

        if (isString) {
            System.out.println("DataTypeError: integer value required\n=======================================");
            return;
        }
        int[] array = arr.clone();
        int sum = 0;
        for (int anArr : array)
            sum = sum + anArr;
        System.out.println("Average value is " + (sum / array.length) + "\n=======================================");
    }

    //return true if a number array is sorted false otherwise
    private static boolean checkSorted() {
        for (int i = 0; i < size - 1; i++) {
            if (arr[i] > arr[i + 1])
                return false;
        }
        return true;
    }

    //function that uses CheckSorted to print output to user
    private static void printCheckSorted() {
        System.out.print("Check if sorted: ");
        if (isString) {
            System.out.print("Cannot work on string.");
            System.out.println("\n=======================================");
            return;
        }
        boolean isSorted = checkSorted();
        if (isSorted) System.out.print("Sorted");
        else System.out.print("Unsorted");
        System.out.println("\n=======================================");

    }

    private static void reverseArray() {
        System.out.println("Reverse Array: \n ");

        if (isString) {
            String reverse = "";
            for (int i = inputString.length() - 1; i >= 0; i--) {
                reverse = reverse + inputString.charAt(i);
            }

            System.out.println("Reversed string is:");
            System.out.println(reverse);
        } else {
            int[] temp;
            temp = Arrays.copyOf(arr, size);
            for (int i = 0; i < temp.length / 2; i++) {
                int tempValue = temp[i];
                temp[i] = temp[temp.length - i - 1];
                temp[temp.length - i - 1] = tempValue;
            }
            System.out.println(Arrays.toString(temp));
        }

        System.out.println("\n=======================================");
    }
  private static void find_Largest_prime()
    {
	System.out.print("find_largest_prime number:\n");
	if(isString)
    	{
    		System.out.println("i can't get prime values from string");
    		System.out.println("\n=======================================");
    		return;
    	}
    	ArrayList<Integer> prime_numbers=new ArrayList<Integer>();
    	boolean isPrime=false;
    	for(int i=0;i<arr.length;i++)
    	{
    		for(int j=2;j<arr[i];j++)
    		{
    			if(arr[i]%j==0)
    			{
    				isPrime=false;
    				break;
    			}
          isPrime=true;
    				
    		}
    		if(isPrime)
    		{
    			prime_numbers.add(new Integer(arr[i]));
    		}
    		isPrime=true;
    	}
	if(prime_numbers.isEmpty())
    	{
    		System.out.println("there is no prime numbers in array");
		System.out.println("\n=======================================");
    		return;
    	}
    	int max=Integer.MIN_VALUE;
    	for(int i=0;i<prime_numbers.size();i++)
    	{
    		if(prime_numbers.get(i)>max)max=prime_numbers.get(i).intValue();
    	}
    	System.out.println("largest Prime :"+max);
	System.out.println("\n=======================================");
    }

  public static void getMedian(){
			
		System.out.println("Get median : \n ");
		if(isString)
	{
 		System.out.println("The function get median doesn't work on strings");
 		System.out.println("\n=======================================");
 		return;
 	}
	        int[] numArray;
		    numArray = Arrays.copyOf(arr, size);
	        Arrays.sort(numArray);
	        double median;
	        if (numArray.length % 2 == 0) {
	            median = ((double) numArray[numArray.length / 2] + (double) numArray[numArray.length / 2 - 1]) / 2;
	            System.out.println("the median is "+median);
	        }
	        else {
	            median = (double) numArray[numArray.length / 2];
	            System.out.println("the median is "+median);
	        }
	System.out.println("\n=======================================");	
	}



}

}


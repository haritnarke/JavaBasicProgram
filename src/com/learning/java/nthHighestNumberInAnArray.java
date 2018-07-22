package com.learning.java;

import java.util.Scanner;

public class nthHighestNumberInAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int unsortedarray[] = { 89, 1, 4, 64, 3, 5, 1, 657, 89, 11, 33, 456 };
		int lengthofarray = unsortedarray.length;
		sorting(unsortedarray, lengthofarray);
		displaysorted(unsortedarray, lengthofarray);
		nthHighestNumber(unsortedarray, lengthofarray);

	}

	private static void displaysorted(int[] unsortedarray, int lengthofarray) {
		// TODO Auto-generated method stub
		for (int i = 0; i < lengthofarray; i++) {
		System.out.println(unsortedarray[i]);
		}
	}

	private static void nthHighestNumber(int[] unsortedarray, int lengthofarray) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter the nth highest number you want to display from an array");
		int nth = sc.nextInt();
		sc.close();
		if (nth < lengthofarray) {
			System.out.println("The " + nth + " highest number in an array is   :" + unsortedarray[nth - 1]);
		}

		else {

			System.out.println("Array Length is :" + lengthofarray
					+ "\nAnd you tried to search for Highest number in an array which is greater than the Array lenght");
		}
	}

	private static void sorting(int[] unsortedarray, int lengthofarray) {
		// TODO Auto-generated method stub

		for (int i = 0; i < lengthofarray; i++) {
			for (int j = i + 1; j < lengthofarray; j++) {

				if (unsortedarray[i] < unsortedarray[j]) {

					int temp = unsortedarray[i];
					unsortedarray[i] = unsortedarray[j];
					unsortedarray[j] = temp;
				}
			}
		}
	}
}

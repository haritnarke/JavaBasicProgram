package com.learning.java;

import java.util.Scanner;

public class perfectNumber {

	public static void main(String[] args) {

		System.out.println("\nPlease enter the number for which you want to check if its perfect number or not :");
		Scanner userInput = new Scanner(System.in);
		int checkingIfPerfectNumber = userInput.nextInt();
		userInput.close();

		CheckForPerfectNumberLogic(checkingIfPerfectNumber);

	}

	private static void CheckForPerfectNumberLogic(int checkingIfPerfectNumber) {
		// TODO Auto-generated method stub

		int temp = 0;

		for (int i = 1; i < checkingIfPerfectNumber; i++) {

			if (checkingIfPerfectNumber % i == 0) {
				temp = temp + i;
			}
		}

		if (temp == checkingIfPerfectNumber) {
			System.out.println("\nIts a perfect Number as the addition of all numbers divisible by "
					+ checkingIfPerfectNumber + " comes out to be " + temp);
		} else {

			System.out.println("\nIts not a perfect Number as the addition of all numbers divisible by "
					+ checkingIfPerfectNumber + " comes out to be " + temp);
			System.out.println("All verified");
		}
	}

}

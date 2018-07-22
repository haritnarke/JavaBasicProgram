package com.learning.java;

import java.util.Scanner;


public class printingEvenOrOddNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintEvenOrOdd();
	}

	private static void PrintEvenOrOdd() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Please Enter a number to check if its an Even or Odd Number  :");
		int inputnumber=sc.nextInt();
		sc.close();
		if(inputnumber %2 != 0) {
			
			System.out.println("Its an Odd Number   : "+inputnumber+"\nCongrats you have won 333333 USD amount");
		}
		else {
			System.out.println("Its an Even Number  : "+inputnumber+"\nCongrats you have won 450000 USD amount");
		}
	}

}

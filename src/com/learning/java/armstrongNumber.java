package com.learning.java;

import java.util.Scanner;

public class armstrongNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArmstrongNumber();
	}

	private static void ArmstrongNumber() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter an number to check if its an armstrong   :");
		int num = sc.nextInt();
		sc.close();
		
		int temp=num;
		int logicalNumber=0;
		int reminder=0;
		
		while(temp>0) {
			
			reminder= temp % 10;
			logicalNumber=logicalNumber+(reminder*reminder*reminder);
			temp=temp/10;
		}
		
		if (logicalNumber==num) {

			System.out.println("Its an ArmStrong Number");
		}

		else {

			System.out.println("Its not an ArmStrong Number");
		}
	}

}
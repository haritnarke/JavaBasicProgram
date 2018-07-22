package com.learning.java;

import java.util.Scanner;

public class swapNumbers {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number you want to swap without using any temp variable  :");
		int num1=sc.nextInt();
		
		int num2=sc.nextInt();
		sc.close();
		swapping(num1,num2);
		
	}

	private static void swapping(int num1, int num2) {
		// TODO Auto-generated method stub
		
		System.out.println("The number before swappings are " +num1+" & "+num2);
		num1=num1+num2;
		num2=num1-num2;
		num1=num1-num2;
		
		System.out.println("The number after swappings are " +num1+" & "+num2);
	}
	
}

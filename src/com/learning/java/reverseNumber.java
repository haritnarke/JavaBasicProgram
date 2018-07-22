package com.learning.java;

import java.util.Scanner;

public class reverseNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		ReverseTheNumber(num);
		
	}

	private static void ReverseTheNumber(int num) {
		// TODO Auto-generated method stub
		
		int c=0;
		int reminder=0;
		while(num > 0) {
			
			reminder=reminder *10;
			reminder= reminder + num %10;
			num = num /10;
		}
		
		System.out.println(reminder);
		}

}

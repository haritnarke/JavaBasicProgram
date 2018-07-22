package com.learning.java;

import java.util.Scanner;

public class factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.println("Take input for factorial number  :");
		int inputnumber = in.nextInt();
		in.close();
		FactorialLogic(inputnumber);
		
	}

	private static void FactorialLogic(int inputnumber) {
		// TODO Auto-generated method stub
		int c=1;
		while(inputnumber > 0) {
			c=c*inputnumber;
			inputnumber--;
			
		}
		
		
		System.out.println("Factorial of a number is   :"+c);
	
	}

}

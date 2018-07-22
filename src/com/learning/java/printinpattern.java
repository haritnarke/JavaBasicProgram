package com.learning.java;

public class printinpattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for( int i=1; i<=10; i++ ){
				for( int j=1; j<=i; j++ ){
				//System.out.println("i = " + i + "; j = " + j + "\n*");
				System.out.print (j+"  ");
			}
			
			System.out.println (); //to print new line for each iteration of outer loop
			
		}
	}

}
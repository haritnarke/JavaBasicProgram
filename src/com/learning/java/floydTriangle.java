package com.learning.java;

import java.util.Scanner;

public class floydTriangle {

	public static void main(String[] args) {
		
		
		Scanner in= new Scanner(System.in);
		System.out.println("Enter the number of rows for floyd Triangle   :");
		int rows=in.nextInt();
		in.close();
		floyd(rows);
	}

	private static void floyd(int rows) {
		// TODO Auto-generated method stub
		int n=0;
		for(int i=1;i<=rows;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(++n+" ");
			}
		System.out.println();
		}
}
	

}

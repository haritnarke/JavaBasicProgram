package com.learning.java;


public class removingDuplicateNumbersFromArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int array[] = { 89,89,1,1, 1, 35, 67, 99, 200, 1,-0, 2, 2, 45, 1, 56, 67, 5, 4, 4 };
		distinctarray(array);
	}

	private static void distinctarray(int[] array) {
		// TODO Auto-generated method stub
		int lenght = array.length;
		int count=0;
		//int temp[] = new int[lenght];
		for (int i = 0; i < lenght; i++) {
			for (int j = i + 1; j < lenght; j++) {
				
				if(array[j]== -0) {
					count++;
				}
			}}
		
		
		for (int i = 0; i < lenght; i++) {
			for (int j = i + 1; j < lenght; j++) {
		
		if (array[i] == array[j]) {
					array[j] = -0;
				}
			}
			//array[i] = array[i];
		}

		for (int i = 0; i < lenght; i++) {
			if (array[i] != -0)
				System.out.println(array[i]);
		}
		if(count>1) {
			System.out.println("-0");
		}
			}
}

package com.learning.java;

public class soritng {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 1, 34, 5, 67, 8, 9, 2, 54 ,1};
		int arraylength = a.length;
		sortinglogic(a, arraylength);
		displaysorted(a, arraylength);
	}

	private static void displaysorted(int[] a, int arraylength) {
		// TODO Auto-generated method stub

		for (int i = 0; i < arraylength; i++)
			System.out.println(a[i]);
	}

	private static void sortinglogic(int[] a, int arraylength) {
		for (int i = 0; i < arraylength; i++) {
			for (int j =i+ 1; j < arraylength; j++) {
				if (a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}

	}

}
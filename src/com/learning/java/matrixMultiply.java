package com.learning.java;

import java.util.Scanner;

public class matrixMultiply {

	public static void main(String[] args) {

		int rows, cols;

		Scanner in = new Scanner(System.in);

		System.out.println("Please Enter number of rows and columns");

		rows = in.nextInt();
		cols = in.nextInt();
		int firstmatrix[][] = new int[rows][cols];
		int secondmatrix[][] = new int[rows][cols];
		int sumofmatrix[][] = new int[rows][cols];

		Inputmatrix(rows, cols, in, firstmatrix, secondmatrix);

		Addition(rows, cols, firstmatrix, secondmatrix, sumofmatrix);
		Substraction(rows, cols, firstmatrix, secondmatrix, sumofmatrix);
		Multiplication(rows, cols, firstmatrix, secondmatrix, sumofmatrix);

	}

	private static void Multiplication(int rows, int cols, int[][] firstmatrix, int[][] secondmatrix,
			int[][] sumofmatrix) {
		// TODO Auto-generated method stub
		int c, d;

		for (c = 0; c < rows; c++)
			for (d = 0; d < cols; d++)
				sumofmatrix[c][d] = firstmatrix[c][d] * secondmatrix[c][d];

		System.out.println("Multiplication of Matrix is :");

		for (c = 0; c < rows; c++)
			for (d = 0; d < cols; d++) {
				System.out.println(sumofmatrix[c][d] + "\t");
			}
		System.out.println();

	}

	private static void Substraction(int rows, int cols, int[][] firstmatrix, int[][] secondmatrix,
			int[][] sumofmatrix) {
		// TODO Auto-generated method stub
		int c, d;

		for (c = 0; c < rows; c++)
			for (d = 0; d < cols; d++)
				sumofmatrix[c][d] = firstmatrix[c][d] - secondmatrix[c][d];

		System.out.println("Substraction of Matrix is :");

		for (c = 0; c < rows; c++)
			for (d = 0; d < cols; d++) {
				System.out.println(sumofmatrix[c][d] + "\t");
			}
		System.out.println();

	}

	private static void Addition(int rows, int cols, int[][] firstmatrix, int[][] secondmatrix, int[][] sumofmatrix) {
		int c, d;

		for (c = 0; c < rows; c++)
			for (d = 0; d < cols; d++)
				sumofmatrix[c][d] = firstmatrix[c][d] + secondmatrix[c][d];

		System.out.println("Sum of Matrix is :");

		for (c = 0; c < rows; c++)
			for (d = 0; d < cols; d++) {
				System.out.println(sumofmatrix[c][d] + "\t");
			}
		System.out.println();

	}

	private static void Inputmatrix(int rows, int cols, Scanner in, int[][] firstmatrix, int[][] secondmatrix) {
		// TODO Auto-generated method stub
		System.out.println("Please Enter elements of first matrix");
		int c, d;

		for (c = 0; c < rows; c++)
			for (d = 0; d < cols; d++)
				firstmatrix[c][d] = in.nextInt();

		System.out.println("Please Enter elements of second matrix");

		for (c = 0; c < rows; c++)
			for (d = 0; d < cols; d++)
				secondmatrix[c][d] = in.nextInt();

		in.close();

	}

}

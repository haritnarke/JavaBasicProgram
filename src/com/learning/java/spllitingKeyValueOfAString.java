package com.learning.java;

public class spllitingKeyValueOfAString {

	public static void main(String[] args) {
		// TODsplitO Auto-generated method stub

		splitString("I love Capgemini");
		replaceString("I Love Capgemini");
	}

	private static void replaceString(String string) {
		// TODO Auto-generated method stub
		String replaced = string.replaceAll("Love", "");
		System.out.println(replaced);
	
	}

	public static void splitString(String parsing) {

		String parseed[] = parsing.split("love");
		int i = parseed.length;
		System.out.println(i);

		for (int j = 0; j < i; j++) {

			System.out.println(parseed[j]);

		}

	}

}

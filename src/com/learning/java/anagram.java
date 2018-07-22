package com.learning.java;

import java.util.Arrays;
import java.util.Scanner;

public class anagram {

	public static void main(String[] args) {
		Scanner SC = new Scanner(System.in);
		String S1 = SC.nextLine();
		String S2 = SC.nextLine();
		SC.close();
		anagram_check(S1, S2);

	}

private static void anagram_check(String s1, String s2) {
		// TODO Auto-generated method stub
		String temp1 = s1.replaceAll(" ", "");
		String temp2 = s2.replaceAll(" ", "");
		if (temp1.length() != temp2.length()) {
		System.out.println("isnt anagram sentence or words as you have used more or less char than original string");
		} 
		
		else {

			if (sorting(temp1).equals(sorting(temp2)))
				
			{
				System.out.println(
						"\n\n\n" + s1 + "\nand\n" + s2 + "\n\n\t\t\t***********Is an example of Anagram***********");
			}

		}
}

private static String sorting(String temp1) {
		
		temp1 = temp1.toLowerCase();
		char temp[] = temp1.toCharArray();

		Arrays.sort(temp);
		

		temp1 = String.copyValueOf(temp);
		return temp1;
	}

}

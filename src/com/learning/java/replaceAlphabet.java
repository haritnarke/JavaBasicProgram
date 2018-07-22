package com.learning.java;

import java.util.Scanner;

public class replaceAlphabet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		replacingmethod2("Engage the mind and soul with classic quotations featuring authors from the ages, with wit, wisdom, and words that inspire.");
		replacingmethod1(
				"Engage the mind and soul with classic quotations featuring authors from the ages, with wit, wisdom, and words that inspire.");
	}

	private static void replacingmethod2(String string) {
		// TODO Auto-generated method stub
		string = string.replaceAll("w", "W");
		System.out.println();
	}

	public static void replacingmethod1(String str) {

		char[] inp = str.toCharArray();
		int cnt = 1;
		int cnt1 = 0;
		System.out.println("This is the string  :" + str);
		System.out.println("Enter the character you want to replace");
		Scanner sc = new Scanner(System.in);

		char replacingchar = 0;
		int nth = 0;
		char replacedchar = 0;
		try {
			replacingchar = sc.next(".").charAt(0);
			System.out.println("Enter the nth number of repetative char you want to replace to  :");
			nth = sc.nextInt();
			System.out.println("Enter the Char you want to replace it with :");
			replacedchar = sc.next(".").charAt(0);
			sc.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(
					"Sorry to say.... But you have entered Something incorrect which have caused the program to terminate\nWe are working further to let you know what incorrect data you have entered\nAs of now please Try again With Correct Data");
			return;
		}

		if (nth == 1) {
			for (int i = 0; i < str.length(); i++) {
				if (inp[i] == replacingchar) {
					inp[i] = replacedchar;
					break;
				}
			}
		}

		else {
			for (int i = 0; i < str.length(); i++) {
				for (int j = i + 1; j < str.length(); j++) {
					if (inp[i] == inp[j]) {

						if (inp[j] == replacingchar) {
							cnt++;
							if (cnt == nth) {

								inp[j] = replacedchar;

							}

							break;
						}

					}
				}
			}

			// System.out.println(cnt +" "+nth);
			// Logic to check if the occurance of char is less than whats requested
			if (cnt < nth) {

				System.out.println("The replacing character *" + replacingchar + "* has " + cnt
						+ " number of occurance where as you have requested for " + nth
						+ " occurance of string which is not present");

				++cnt1;
			}
		}

		// Logic to check if character is present or not
		if (str.indexOf(replacingchar) != -1)
			System.out.println(inp);
		else if (cnt1 == 1) {
			System.out.println("Also the Char *" + replacingchar + "* is not present int the string  :" + str);
		} else
			System.out.println("The Char *" + replacingchar + "* is not present int the string  :" + str);

	}
}

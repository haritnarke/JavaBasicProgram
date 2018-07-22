package com.learning.java;

import java.util.Scanner;

public class fizzbuzzUsingDivide {

	public static void main(String[] args) {

		
		initialisestartofloop();
	}

	
	
	
	
	private static void fizzbuzz_logic(int cnt, int cnt1, int cnt2, int loopstartnumber, int loopendnumber) {
		// TODO Auto-generated method stub

		
		for (int i= loopstartnumber; i <= loopendnumber; i++) {

			int fizz = i / 3;
			int buzz = i / 5;
			int fizzbuzz = i / 15;

			// Logic to print if number is divisble by both 3 and 5
			if (fizzbuzz != 0 && cnt2 == fizzbuzz) {

				System.out.println(i + "   :FizzBuzz");
				cnt2++;
				cnt++;
				cnt1++;
			}

			// Logic to print if number is divisble by 3
			else if (fizz != 0 && cnt == fizz) {

				System.out.println(i + "   :Fizz");
				cnt++;
			}

			// Logic to print if number is divisible by 5
			else if (buzz != 0 && cnt1 == buzz) {

				System.out.println(i + "   :Buzz");
				cnt1++;

			}

			// Logic to print the number if its not Fizz or Buzz or FizzBuzz
			else {

				System.out.println(i);
			}
		}
	}

	
	
	
	
private static void initialisestartofloop() {
		
		// TODO Auto-generated method stub
	Scanner sc = new Scanner(System.in);
    System.out.println("Enter the odd number you want to start with");
	int loopstartnumber = sc.nextInt();
	sc.close();
  if(loopstartnumber%2==0) {
	System.out.println("Not an odd number");
	return;
   }
		System.out.println("Enter the number you want to end with");
		int loopendnumber = sc.nextInt();

		sc.close();

		// Logic to initialize cnt during start of loop if we start somewhere from
		// middle
		int cnt = loopstartnumber / 3;
		int cnt1 = loopstartnumber / 5;
		int cnt2 = loopstartnumber / 15;
		//System.out.println(loopstartnumber % 2);

		if (cnt == 0) {
			cnt = 1;
		} else {
			cnt++;
		}

		if (cnt1 == 0) {
			cnt1 = 1;
		} else {
			cnt1++;
		}

		if (cnt2 == 0) {
			cnt2 = 1;
		}else {
			cnt2++;
			
		}

		fizzbuzz_logic(cnt,cnt1,cnt2,loopstartnumber,loopendnumber);
	}

	
	
	
}






package com.learning.java;

public class fizzbuzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fizzbuzz_logic();
	}

	private static void fizzbuzz_logic() {
		// TODO Auto-generated method stub
		for(int i=1;i<=100;i++) {
			
			int fizz= i %3;
			int buzz= i %5;
			int fizzbuzz= i %15;
	
			if(fizz==0) {
				
				if(fizzbuzz==0) {
					System.out.println("FizzBuzz   :"+i);
					continue;
				}
					System.out.println("Fizz       :"+i);
			}
			
						
			if(buzz==0) {
					System.out.println("Buzz 	   :"+i);
			}
}
}
}
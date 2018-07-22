package com.learning.java;

public class reversestring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	  
		
		String name="tesset";
		
		reverselogic(name);
		palindrome(name);
		reverselogic1("kjHaritNarke 21321kjdsfh   123456789");
	}

	
	private static void palindrome(String name) {
		// TODO Auto-generated method stub
		int stringlength=name.length();
		//System.out.println(stringlength);
		char[] stringtoarray= name.toCharArray();
		
	
		 
		for(int i = 0; i < stringlength / 2; i++)
		{
		    char temp = stringtoarray[i];
		    stringtoarray[i] = stringtoarray[stringlength - i - 1];
		    stringtoarray[stringlength - i - 1] = temp;
		} 
		
		String reversedword=String.copyValueOf(stringtoarray);
		if(reversedword.equals(name)) {
        	System.out.println("\nEntered String is :"+name+"\nReversed String is :"+reversedword);
        	System.out.println("String is a palindrome");
        }
	
        else {
        	System.out.println("Entered String is :"+name+"\nReversed String is :"+reversedword);
        	System.out.println("String is not a palindrome");
        }
	}

	private static void reverselogic(String name) {
		// TODO Auto-generated method stub
		int lengthofstring =name.length();
		char[] stringtochararray=name.toCharArray();
		
		for(int i=lengthofstring-1;i>=0;i--) {
			System.out.println(stringtochararray[i]);
		}
	
	}
		
	private static void reverselogic1(String name) {
		// TODO Auto-generated method stub
		int lengthofstring =name.length();
		System.out.println(lengthofstring);
		char[] stringtochararray=name.toCharArray();
		int j=0;
		for(int i=lengthofstring-1;i>=(lengthofstring-1)/2;i--) {
			char temp=stringtochararray[j];
			stringtochararray[j]=stringtochararray[i];
			stringtochararray[i]=temp;
			//System.out.println(i +"&"+j);
			j++;
		}
		
		
		
	System.out.println("Reverse Logic 1   :"+new String(stringtochararray));
	}
		


}

	


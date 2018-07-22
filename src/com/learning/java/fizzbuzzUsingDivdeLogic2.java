package com.learning.java;

public class fizzbuzzUsingDivdeLogic2 {

	public static void main(String[] args) 
	{
	int i=1;
	int j=1;
	int y=1;
	int k=0;
	int z=0;
	int x=0;
	for (i=11;i<51;i++)
	{
	if ((i/3==j || i/5==y) && (i-15==x))
	{
	System.out.println("The number is "+i+" is FIZZBUZZ");
	j=j+1;
	x=x+15;
	y=y+1;
	}
	if (i/3==j  )
	{
	System.out.println("The number is "+i+" is FIZZ");
	j=j+1;
	z=z+3;
	}
	if (i/5==y )
	{
	System.out.println("The number is "+i+" is BUZZ");
	y=y+1;
	k=k+5;




	}

	}

	}
}

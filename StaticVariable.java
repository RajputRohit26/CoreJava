package com.basic;

import java.util.Scanner;

public class StaticVariable {
	
	static int a;
	void setValue()
	{
		Scanner sc =new Scanner(System.in);
		System.out.print("Enter A :");
		a=sc.nextInt();
		
	}
	void printValue()
	{
		System.out.println("A :"+a);
	}
	public static void main(String[] args) {
		StaticVariable s1=new StaticVariable();
		StaticVariable s2=new StaticVariable();
		StaticVariable s3=new StaticVariable();
		
		s1.setValue();
		s2.setValue();
		s3.setValue();
		
		s1.printValue();
		s2.printValue();
		s3.printValue();
		
	}

}

package com.basic;

import java.util.Scanner;

public class Variable {
	public static void main(String[] args) {
		int a,b,c;
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter A :");
		a=sc.nextInt();
		System.out.print("Enter B :");
        b=sc.nextInt();
        c=a+b;
		System.out.println("Addition : "+c);
		
		System.out.print("Enter A :");
		a=sc.nextInt();
		System.out.print("Enter B :");
		b=sc.nextInt();
		c=a-b;
		System.out.println("Substraction :"+c);
		
		System.out.print("Enter A :");
		a=sc.nextInt();
		System.out.print("Enter B :");
		b=sc.nextInt();
		c=a/b;
		System.out.println("Division :"+c);
		
		System.out.print("Enter A :");
		a=sc.nextInt();
		System.out.print("Enter B :");
		b=sc.nextInt();
		c=a*b;
		System.out.println("Multiplication :"+c);
		
		
		
		
		
	}

}

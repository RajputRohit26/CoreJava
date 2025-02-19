package com.basic;

import java.util.Scanner;

public class Whiledemo {
	public static void main(String[] args) {
		int n,sum=0;
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter N :");
		n=sc.nextInt();
		do
		{
			sum=sum+n;
			n--;
			
		}while(n>=0);
		System.out.println("Sum :"+sum);
	}

}

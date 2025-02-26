package com.basic;

public class MethodOverloading {
	void test()
	{
		System.out.println("test with no argument");
	
	}
	void test(int a)
	{
		System.out.println("test with one argument");
	}
	void test(int a,int b)
	{
		System.out.println("test with two argument");
	}
	public static void main(String[] args) {
		MethodOverloading m=new MethodOverloading();
		m.test();
		m.test(10);
		m.test(20,30);
	}

}

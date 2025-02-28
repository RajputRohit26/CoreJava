package com.basic;

class Student1
{
	int rno;
	String sname;
	public Student1()
	{
		System.out.println("Default Constructor Called");
	}
	public Student1(int rno,String sname)
	{
		this();
		System.out.println("Parameterized constructor called");
		this.rno=rno;
		this.sname=sname;
	}
	
}

public class ThisKeyword {
	public static void main(String[] args) {
		Student1 s1= new Student1(1,"Raj");
	}

}

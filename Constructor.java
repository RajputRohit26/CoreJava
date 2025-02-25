package com.basic;
class Box
{
	double width,height,depth;
	Box()
	{
		System.out.println("Default constructor called");
		width=3;
		height=4;
		depth=5;
		
	}
	Box(double w,double h,double d)
	{
		System.out.println("Parameterized constructor called");
		width=w;
		height=h;
	    depth=d;
	}
	Box(Box b)
	{
		System.out.println("Copy constructor called");
		width=b.width;
		height=b.height;
		depth=b.depth;
	}
	void volume()
	{
		System.out.println("Volume :"+(width*height*depth));
	}
}

public class Constructor {
	public static void main(String[] args) {
		Box b1=new Box();
		b1.volume();
		 
		Box b2=new Box(4,5,6);
		b2.volume();
		
		Box b3=new Box(b1);
		b3.volume();
		
	}

}

package com.basic;
interface Ifs1
{
	static void meth1()
	{
		System.out.println("Meth1 is defined in Ifs1");
	}
	void meth2();
}
interface Ifs2 extends Ifs1
{
	void meth3();
	void meth4();

}
class InterfaceImpl implements Ifs2
{
	public void meth2() {
		System.out.println("meth2");
	}
	public void meth3() {
		System.out.println("Meth3");
	}
	public void meth4() {
		System.out.println("Meth4");
	}
}

public class interfacedemo {
	public static void main(String[] args) {
		InterfaceImpl i=new InterfaceImpl();
		Ifs1.meth1();
		i.meth2();
		i.meth3();
		i.meth4();
	}

}

package com.test.dimondOperator;

class X<T> {
	   public X(T t) { }
	   public T get() { return null; }
	}

public class Test {
	
	static int f(String s) { return 1; }
	   static int f(Object o) { return 2; }

	   public static void main(String[] args) {
	      System.out.println(f (new X<>("").get()));
	   }

}

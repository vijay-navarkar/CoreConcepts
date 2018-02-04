package com.test.dimondOperator;

public class Foo<T> {

	Foo(T t) {
	}

	Foo<T> get(T t) {
		return this;
	}

}

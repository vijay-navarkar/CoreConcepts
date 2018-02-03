package com.test.createObject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Different5WaysToCreateObject {
	
	public static void main(String[] args) {
		
	
		Student student = new Student();
		System.out.println("First  way to create object -" + student);
		
		try {
			
			Student student2 = (Student) Class.forName("com.test.createObject.Student").newInstance();
			System.out.println("Second way to create object -"+student2);
			Student student3 = Student.class.newInstance();
			System.out.println("Third  way to create object -"+student3);
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			 Student student4 = (Student) student.clone();
			 System.out.println("Fourth way to create object -"+student4);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		//serialization
		Student student2 = new Student();
		student2.setRollNo(11);
		student2.setFirstName("firstName1");
		student2.setLastName("lastName1");
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("object.ser");
			ObjectOutputStream objectOutputStream= new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(student2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Student student5 = new Student();
			FileInputStream fis = new FileInputStream("object.ser");
			ObjectInputStream ois= new ObjectInputStream(fis);
			student5 = (Student) ois.readObject();
			System.out.println("fifth  way to create object -" + student5);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		try {
			Constructor<Student> constructor = (Constructor<Student>) Student.class.getConstructor();
			Student student3 = constructor.newInstance();
			System.out.println("fifth  way to create object -" + student3);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
	}

}

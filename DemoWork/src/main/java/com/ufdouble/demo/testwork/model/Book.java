package com.ufdouble.demo.testwork.model;

/**
 * ClassName: Book  
 * 书本类，name:名称  number：数量
 * @author DOUBLE
 * @version
 */
public class Book {
	
	private String name;
	private int number;
	
	public Book(String name, int number) {
		super();
		this.name = name;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}

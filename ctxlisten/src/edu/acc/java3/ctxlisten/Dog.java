package edu.acc.java3.ctxlisten;

public class Dog {
	private String name;
	private String breed;
	
	public Dog(String name, String breed) {
		this.name = name;
		this.breed = breed;
	}
	
	public String getName() { return name; }
	public String getBreed() { return breed; }

	@Override
	public String toString() {
		return String.format("%s is a %s", name, breed);
	}
}
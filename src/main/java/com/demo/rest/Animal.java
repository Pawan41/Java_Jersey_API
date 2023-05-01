package com.demo.rest;

public class Animal {

	private int animalId;
	private String animalName;
	private String animalGender;
	private String animalZooName;
	
	//create a default constructor
	public Animal() {
			
	}
	public void setAnimalId(int animalId) {
		this.animalId = animalId;
	}
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	public void setAnimalGender(String animalGender) {
		this.animalGender = animalGender;
	}
	public void setAnimalZooName(String animalZooName) {
		this.animalZooName = animalZooName;
	}
	public int getAnimalId() {
		return animalId;
	}
	public String getAnimalName() {
		return animalName;
	}
	public String getAnimalGender() {
		return animalGender;
	}
	public String getAnimalZooName() {
		return animalZooName;
	}
	
}

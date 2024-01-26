package com.zoi4erom.animalnetworkbook.persistence.entity;

import java.util.List;
import java.util.UUID;

public class Shelter extends Entity{
	private String name;
	private final String address;
	private final String phone;
	private int numbersOfAnimals;
	private final int capacityOfAnimals;
	private List<Animal> animals;

	public Shelter(UUID id, String name, String address, String phone, int numbersOfAnimals,
	    int capacityOfAnimals, List<Animal> animals) {
		super(id);
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.numbersOfAnimals = numbersOfAnimals;
		this.capacityOfAnimals = capacityOfAnimals;
		this.animals = animals;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumbersOfAnimals(int numbersOfAnimals) {
		this.numbersOfAnimals = numbersOfAnimals;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public int getNumbersOfAnimals() {
		return numbersOfAnimals;
	}

	public int getCapacityOfAnimals() {
		return capacityOfAnimals;
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	@Override
	public String toString() {
		return "Shelter{" +
		    "name='" + name + '\'' +
		    ", address='" + address + '\'' +
		    ", phone='" + phone + '\'' +
		    ", numbersOfAnimals=" + numbersOfAnimals +
		    ", capacityOfAnimals=" + capacityOfAnimals +
		    ", id=" + id +
		    '}';
	}
}

package com.zoi4erom.animalnetworkbook.persistence.entity;

import java.util.UUID;

public class Animal extends Entity{
	private String name;
	private final int age;
	private final String species;
	private final String breed;
	private final String dateOfDelivery;
	private final Shelter shelter;

	public Animal(UUID id, String name, int age, String species, String breed,
	    String dateOfDelivery, Shelter shelter) {
		super(id);
		this.name = name;
		this.age = age;
		this.species = species;
		this.breed = breed;
		this.dateOfDelivery = dateOfDelivery;
		this.shelter = shelter;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getSpecies() {
		return species;
	}

	public String getBreed() {
		return breed;
	}

	public String getDateOfDelivery() {
		return dateOfDelivery;
	}

	public Shelter getShelter() {
		return shelter;
	}

	@Override
	public String toString() {
		return "Animal{" +
		    "name='" + name + '\'' +
		    ", age=" + age +
		    ", species='" + species + '\'' +
		    ", breed='" + breed + '\'' +
		    ", dateOfDelivery='" + dateOfDelivery + '\'' +
		    ", shelter=" + shelter +
		    ", id=" + id +
		    '}';
	}
}
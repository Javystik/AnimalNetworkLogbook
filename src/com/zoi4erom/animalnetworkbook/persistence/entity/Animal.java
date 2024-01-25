package com.zoi4erom.animalnetworkbook.persistence.entity;

import com.zoi4erom.animalnetworkbook.persistence.exception.ExceptionTemplate;
import com.zoi4erom.animalnetworkbook.persistence.validation.Validator;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		final String FIELD_NAME = "назви";

		if (Validator.isFieldBlankValidate(name)){
			errors.add(ExceptionTemplate.EMPTY_FIELD_EXCEPTION.getTemplate().formatted(FIELD_NAME));
		}
		if(Validator.isFieldSizeValidate(name, 4, 38)){
			errors.add((ExceptionTemplate.TOO_SHORT_LONG_EXCEPTION.getTemplate().formatted(FIELD_NAME, 2, 38)));
		}
		if (!this.errors.isEmpty()) {
			System.out.println("Помилки валідації: " + errors);
			return;
		}
		this.name = name;
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
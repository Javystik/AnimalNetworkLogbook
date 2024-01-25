package com.zoi4erom.animalnetworkbook.persistence.entity;

import com.zoi4erom.animalnetworkbook.persistence.exception.ExceptionTemplate;
import com.zoi4erom.animalnetworkbook.persistence.validation.Validator;
import java.util.UUID;

public class Shelter extends Entity{
	private String name;
	private final String address;
	private final String phone;
	private int numbersOfAnimals;
	private final int capacityOfAnimals;

	public Shelter(UUID id, String name, String address, String phone, int numbersOfAnimals,
	    int capacityOfAnimals) {
		super(id);
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.numbersOfAnimals = numbersOfAnimals;
		this.capacityOfAnimals = capacityOfAnimals;
	}

	public void setName(String name) {
		final String FIELD_LOGIN = "логіну";

		if (Validator.isFieldBlankValidate(name)){
			errors.add(ExceptionTemplate.EMPTY_FIELD_EXCEPTION.getTemplate().formatted(FIELD_LOGIN));
		}
		if(Validator.isFieldSizeValidate(name, 4, 52)){
			errors.add((ExceptionTemplate.TOO_SHORT_LONG_EXCEPTION.getTemplate().formatted(FIELD_LOGIN, 4, 52)));
		}
		if (!this.errors.isEmpty()) {
			System.out.println("Помилки валідації: " + errors);
			return;
		}
		this.name = name;
	}
	public void setNumbersOfAnimals(int numbersOfAnimals) {
		this.numbersOfAnimals = numbersOfAnimals;
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

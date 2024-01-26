package com.zoi4erom.animalnetworkbook.persistence.entity;

import java.time.LocalDate;
import java.util.UUID;

public class Request extends Entity{
	private String name;
	private Animal animal;
	private User user;
	private String status;
	private LocalDate requestCreateData;

	public Request(UUID id, String name, Animal animal, User user, String status,
	    LocalDate requestCreateData) {
		super(id);
		this.name = name;
		this.animal = animal;
		this.user = user;
		this.status = status;
		this.requestCreateData = requestCreateData;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setRequestCreateData(LocalDate requestCreateData) {
		this.requestCreateData = requestCreateData;
	}

	public String getName() {
		return name;
	}

	public Animal getAnimal() {
		return animal;
	}

	public User getUser() {
		return user;
	}

	public String getStatus() {
		return status;
	}

	public LocalDate getRequestCreateData() {
		return requestCreateData;
	}
}

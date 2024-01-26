package com.zoi4erom.animalnetworkbook.persistence.entity;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class User extends Entity {
	private String fullName;
	private String password;
	private final String phoneNumber;
	private String homeAddress;
	private String email;
	private final LocalDate dateOfBorn;

	public User(UUID id, String fullName, String password, String phoneNumber,
	    String homeAddress,
	    String email, LocalDate dateOfBorn) {
		super(id);
		this.fullName = fullName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.homeAddress = homeAddress;
		this.email = email;
		this.dateOfBorn = dateOfBorn;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public String getPassword() {
		return password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getDateOfBorn() {
		return dateOfBorn;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		if (!super.equals(o)) {
			return false;
		}
		User client = (User) o;
		return Objects.equals(phoneNumber, client.phoneNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), phoneNumber);
	}

	@Override
	public String toString() {
		return "Client{" +
		    "fullName='" + fullName + '\'' +
		    ", password='" + password + '\'' +
		    ", phoneNumber='" + phoneNumber + '\'' +
		    ", homeAddress='" + homeAddress + '\'' +
		    ", email='" + email + '\'' +
		    ", dateOfBorn=" + dateOfBorn +
		    ", id=" + id +
		    '}';
	}
}
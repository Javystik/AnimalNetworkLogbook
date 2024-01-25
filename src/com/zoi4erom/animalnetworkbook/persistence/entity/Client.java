package com.zoi4erom.animalnetworkbook.persistence.entity;

import com.zoi4erom.animalnetworkbook.persistence.exception.ExceptionTemplate;
import com.zoi4erom.animalnetworkbook.persistence.validation.Validator;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Client extends Entity {
	private String fullName;
	private String password;
	private final String phoneNumber;
	private String homeAddress;
	private String email;
	private final LocalDate dateOfBorn;
	public Client(UUID id, String fullName, String password, String phoneNumber, String homeAddress,
	    String email, LocalDate dateOfBorn) {
		super(id);
		setFullName(fullName);
		setPassword(password);
		this.phoneNumber = phoneNumber;
		setHomeAddress(homeAddress);
		setEmail(email);
		this.dateOfBorn = dateOfBorn;
	}

	public void setFullName(String fullName) {
		final String FIELD_FIO = "логіну";

		if (Validator.isFieldBlankValidate(fullName)){
			errors.add(ExceptionTemplate.EMPTY_FIELD_EXCEPTION.getTemplate().formatted(FIELD_FIO));
		}
		if(Validator.isFieldSizeValidate(fullName, 4, 38)){
			errors.add((ExceptionTemplate.TOO_SHORT_LONG_EXCEPTION.getTemplate().formatted(FIELD_FIO, 4, 38)));
		}

		if (!this.errors.isEmpty()) {
			System.out.println("Помилки валідації: " + errors);
			return;
		}
		this.fullName = fullName;
	}
	public void setPassword(String password) {
		final String FIELD_PASSWORD = "паролю";

		if (Validator.isFieldBlankValidate(password)){
			errors.add(ExceptionTemplate.EMPTY_FIELD_EXCEPTION.getTemplate().formatted(FIELD_PASSWORD));
		}
		if(Validator.isFieldSizeValidate(FIELD_PASSWORD, 4, 38)){
			errors.add((ExceptionTemplate.TOO_SHORT_LONG_EXCEPTION.getTemplate().formatted(FIELD_PASSWORD, 4, 38)));
		}
		if (Validator.isFieldPasswordValidate(password)) {
			errors.add(ExceptionTemplate.WEAK_PASSWORD_EXCEPTION.getTemplate().formatted(FIELD_PASSWORD));
		}

		if (!this.errors.isEmpty()) {
			System.out.println("Помилки валідації: " + errors);
			return;
		}
		this.password = password;
	}
	public void setHomeAddress(String homeAddress) {
		final String FIELD_HOME_ADDRESS = "домашнього адресу";

		if(Validator.isFieldBlankValidate(homeAddress)){
			errors.add(ExceptionTemplate.EMPTY_FIELD_EXCEPTION.getTemplate().formatted(FIELD_HOME_ADDRESS));
		}
		if (!this.errors.isEmpty()) {
			System.out.println("Помилки валідації: " + errors);
			return;
		}
		this.homeAddress = homeAddress;
	}
	public void setEmail(String email) {
		final String FIELD_EMAIL = "електроної пошти";

		if(Validator.isFieldBlankValidate(email)){
			errors.add(ExceptionTemplate.EMPTY_FIELD_EXCEPTION.getTemplate().formatted(FIELD_EMAIL));
		}
		if (!this.errors.isEmpty()) {
			System.out.println("Помилки валідації: " + errors);
			return;
		}

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
		Client client = (Client) o;
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
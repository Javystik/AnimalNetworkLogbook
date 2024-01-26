package com.zoi4erom.animalnetworkbook;

import static java.lang.System.out;

import com.github.javafaker.Faker;
import com.zoi4erom.animalnetworkbook.persistence.entity.User;
import com.zoi4erom.animalnetworkbook.persistence.repository.RepositoryFactory;
import com.zoi4erom.animalnetworkbook.persistence.repository.contracts.UserRepository;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {

	public static void main(String[] args) {
		RepositoryFactory jsonRepositoryFactory = RepositoryFactory
		    .getRepositoryFactory(RepositoryFactory.JSON);
		UserRepository userRepository = jsonRepositoryFactory.getUserRepository();
		List<User> users = createFakeUsers(10);

		for (User user: users){
			userRepository.add(user);
		}

		userRepository.findAll().forEach(out::println);

		jsonRepositoryFactory.commit();
	}
	public static List<User> createFakeUsers(int numberOfUsers) {
		List<User> fakeUsers = new ArrayList<>();
		Faker faker = new Faker();

		for (int i = 0; i < numberOfUsers; i++) {
			UUID userId = UUID.randomUUID();
			String fullName = faker.name().fullName();
			String password = faker.internet().password();
			String phoneNumber = faker.phoneNumber().cellPhone();
			String homeAddress = faker.address().fullAddress();
			String email = faker.internet().emailAddress();
			LocalDate dateOfBirth = faker.date().birthday().toInstant().atZone(
			    ZoneId.of(faker.address().timeZone())).toLocalDate();

			User fakeUser = new User(userId, fullName, password, phoneNumber, homeAddress, email, dateOfBirth);
			fakeUsers.add(fakeUser);
		}

		return fakeUsers;
	}
}

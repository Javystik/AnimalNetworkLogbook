package com.zoi4erom.animalnetworkbook;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.zoi4erom.animalnetworkbook.persistence.entity.Client;
import com.zoi4erom.animalnetworkbook.persistence.exception.EntityArgumentException;
import com.zoi4erom.animalnetworkbook.util.LocalDateDeserializer;
import com.zoi4erom.animalnetworkbook.util.LocalDateSerializer;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {
	public static void main(String[] args) {
		Gson gson = new GsonBuilder()
		    .registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
		    .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
		    .create();

		// Серіалізація
		List<Client> users = generateUsers(5);
		String json = gson.toJson(users);
		System.out.println("Serialized JSON:\n" + json);

		// Десеріалізація
		List<Client> deserializedUsers = gson.fromJson(json, new TypeToken<List<Client>>() {}.getType());
		System.out.println("\nDeserialized Users:");
		for (Client user : deserializedUsers) {
			System.out.println(user);
		}
	}
	public static List<Client> generateUsers(int count) {
		List<Client> users = new ArrayList<>();
		Faker faker = new Faker();

		for (int i = 0; i < count; i++) {
			UUID userId = UUID.randomUUID();
			String password = faker.internet().password();
			String email = faker.internet().emailAddress();
			LocalDate birthday = faker.date()
			    .birthday()
			    .toInstant()
			    .atZone(ZoneId.systemDefault())
			    .toLocalDate();
			String fullName = faker.name().fullName();
			String phoneNumber = faker.phoneNumber().phoneNumber();
			String homeAddress = faker.address().fullAddress();

			Client user = new Client(userId, fullName, password, phoneNumber, homeAddress, email, birthday);
			users.add(user);
		}
		return users;
	}
}

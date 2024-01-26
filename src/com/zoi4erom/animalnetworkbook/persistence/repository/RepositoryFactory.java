package com.zoi4erom.animalnetworkbook.persistence.repository;

import com.zoi4erom.animalnetworkbook.persistence.repository.contracts.AnimalRepository;
import com.zoi4erom.animalnetworkbook.persistence.repository.contracts.RequestRepository;
import com.zoi4erom.animalnetworkbook.persistence.repository.contracts.ShelterRepository;
import com.zoi4erom.animalnetworkbook.persistence.repository.contracts.UserRepository;
import com.zoi4erom.animalnetworkbook.persistence.repository.impl.json.JsonRepositoryFactory;
import org.apache.commons.lang3.NotImplementedException;

public abstract class RepositoryFactory {
	public static final int JSON = 1;
	public static final int XML = 2;
	public static final int POSTGRESQL = 3;
	public static com.zoi4erom.animalnetworkbook.persistence.repository.RepositoryFactory getRepositoryFactory(int whichFactory) {
		return switch (whichFactory) {
			case JSON -> JsonRepositoryFactory.getInstance();
			case XML -> throw new NotImplementedException("Робота з XML файлами не реалізована.");
			case POSTGRESQL -> throw new NotImplementedException(
			    "Робота з СУБД PostgreSQL не реалізована.");
			default -> throw new IllegalArgumentException(
			    "Помилка при виборі фабрики репозиторіїв.");
		};
	}

	public abstract UserRepository getUserRepository();

	public abstract RequestRepository getRequestRepository();

	public abstract ShelterRepository getShelterRepository();

	public abstract AnimalRepository getAnimalRepository();

	public abstract void commit();

}

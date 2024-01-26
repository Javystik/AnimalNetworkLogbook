package com.zoi4erom.animalnetworkbook.persistence.repository.contracts;

import com.zoi4erom.animalnetworkbook.persistence.entity.Animal;
import com.zoi4erom.animalnetworkbook.persistence.entity.Shelter;
import com.zoi4erom.animalnetworkbook.persistence.repository.Repository;
import java.util.Optional;
import java.util.Set;

public interface AnimalRepository extends Repository<Animal> {
	Optional<Animal> findByName(String animalName);
	Set<Animal> findBySpecies(String species);
	Set<Animal> findByBreed(String breed);
}

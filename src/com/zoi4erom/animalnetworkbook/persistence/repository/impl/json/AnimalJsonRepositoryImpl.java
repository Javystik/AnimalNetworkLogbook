package com.zoi4erom.animalnetworkbook.persistence.repository.impl.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zoi4erom.animalnetworkbook.persistence.entity.Animal;
import com.zoi4erom.animalnetworkbook.persistence.entity.Shelter;
import com.zoi4erom.animalnetworkbook.persistence.entity.User;
import com.zoi4erom.animalnetworkbook.persistence.repository.contracts.AnimalRepository;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

class AnimalJsonRepositoryImpl extends GenericJsonRepository<Animal> implements AnimalRepository {

	public AnimalJsonRepositoryImpl(Gson gson) {
		super(gson, JsonPathFactory.ANIMALS.getPath(), TypeToken
		    .getParameterized(Set.class, User.class)
		    .getType());
	}

	@Override
	public Optional<Animal> findByName(String animalName) {
		return entities.stream().filter(u -> u.getName().equals(animalName)).findFirst();
	}
	@Override
	public Set<Animal> findBySpecies(String species) {
		return entities.stream().filter(l -> l.getSpecies().equals(species))
		    .collect(Collectors.toSet());
	}

	@Override
	public Set<Animal> findByBreed(String breed) {
		return entities.stream().filter(l -> l.getBreed().equals(breed))
		    .collect(Collectors.toSet());
	}
}

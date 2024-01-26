package com.zoi4erom.animalnetworkbook.persistence.repository.impl.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zoi4erom.animalnetworkbook.persistence.entity.Shelter;
import com.zoi4erom.animalnetworkbook.persistence.entity.User;
import com.zoi4erom.animalnetworkbook.persistence.repository.contracts.ShelterRepository;
import java.util.Optional;
import java.util.Set;

class ShelterJsonRepositoryImpl extends GenericJsonRepository<Shelter> implements ShelterRepository {
	public ShelterJsonRepositoryImpl(Gson gson) {
		super(gson, JsonPathFactory.SHELTERS.getPath(), TypeToken
		    .getParameterized(Set.class, User.class)
		    .getType());
	}

	@Override
	public Optional<Shelter> findByShelterName(String shelterName) {
		return entities.stream().filter(u -> u.getName().equals(shelterName)).findFirst();
	}

	@Override
	public Optional<Shelter> findByEmail(String email) {
		return entities.stream().filter(u -> u.getAddress().equals(email)).findFirst();
	}

	@Override
	public Optional<Shelter> findByAddress(String address) {
		return entities.stream().filter(u -> u.getAddress().equals(address)).findFirst();
	}
}

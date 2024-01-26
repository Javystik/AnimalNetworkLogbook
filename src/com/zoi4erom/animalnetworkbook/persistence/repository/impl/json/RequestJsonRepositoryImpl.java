package com.zoi4erom.animalnetworkbook.persistence.repository.impl.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zoi4erom.animalnetworkbook.persistence.entity.Animal;
import com.zoi4erom.animalnetworkbook.persistence.entity.Request;
import com.zoi4erom.animalnetworkbook.persistence.entity.User;
import com.zoi4erom.animalnetworkbook.persistence.repository.contracts.RequestRepository;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

class RequestJsonRepositoryImpl extends GenericJsonRepository<Request> implements RequestRepository {
	public RequestJsonRepositoryImpl(Gson gson) {
		super(gson, JsonPathFactory.REQUESTS.getPath(), TypeToken
		    .getParameterized(Set.class, User.class)
		    .getType());
	}

	public Set<Request> getAllRequests() {
		return entities.stream().collect(Collectors.toSet());
	}

	@Override
	public Set<Request> findAllByUser(User user) {
		return entities.stream()
		    .filter(request -> user.equals(request.getUser()))
		    .collect(Collectors.toSet());
	}

	@Override
	public Set<Request> findAllByAnimal(Animal animal) {
		return entities.stream()
		    .filter(request -> request.getAnimal().equals(animal))
		    .collect(Collectors.toSet());
	}

	@Override
	public Optional<Request> findByName(String requestName) {
		return entities.stream()
		    .filter(request -> requestName.equals(request.getName()))
		    .findFirst();
	}

	@Override
	public Optional<Request> findByStatus(String status) {
		return entities.stream()
		    .filter(request -> status.equals(request.getStatus()))
		    .findFirst();
	}
}
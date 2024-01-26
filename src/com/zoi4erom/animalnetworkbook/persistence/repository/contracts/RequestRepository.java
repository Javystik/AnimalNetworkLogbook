package com.zoi4erom.animalnetworkbook.persistence.repository.contracts;

import com.zoi4erom.animalnetworkbook.persistence.entity.Animal;
import com.zoi4erom.animalnetworkbook.persistence.entity.Request;
import com.zoi4erom.animalnetworkbook.persistence.entity.User;
import com.zoi4erom.animalnetworkbook.persistence.repository.Repository;
import java.util.Optional;
import java.util.Set;

public interface RequestRepository extends Repository<Request> {
	Set<Request> getAllRequests();
	Set<Request> findAllByUser(User user);
	Set<Request> findAllByAnimal(Animal animal);
	Optional<Request> findByName(String requestName);
	Optional<Request> findByStatus(String status);
}

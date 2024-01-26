package com.zoi4erom.animalnetworkbook.persistence.repository.contracts;

import com.zoi4erom.animalnetworkbook.persistence.entity.Animal;
import com.zoi4erom.animalnetworkbook.persistence.entity.Shelter;
import com.zoi4erom.animalnetworkbook.persistence.entity.User;
import com.zoi4erom.animalnetworkbook.persistence.repository.Repository;
import java.util.Optional;
import java.util.Set;

public interface ShelterRepository extends Repository<Shelter> {
	Optional<Shelter> findByShelterName(String shelterName);
	Optional<Shelter> findByEmail(String email);
	Optional<Shelter> findByAddress(String address);
}

package com.zoi4erom.animalnetworkbook.persistence.repository.contracts;

import com.zoi4erom.animalnetworkbook.persistence.entity.User;
import com.zoi4erom.animalnetworkbook.persistence.repository.Repository;
import java.util.Optional;

public interface UserRepository extends Repository<User> {
	Optional<User> findByFullName(String fullName);

	Optional<User> findByEmail(String email);
}

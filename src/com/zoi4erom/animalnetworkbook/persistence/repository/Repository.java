package com.zoi4erom.animalnetworkbook.persistence.repository;

import com.zoi4erom.animalnetworkbook.persistence.entity.Entity;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.function.Predicate;

public interface Repository<E extends Entity> {
	Optional<E> findById(UUID id);

	Set<E> findAll();

	Set<E> findAll(Predicate<E> filter);

	E add(E entity);

	boolean remove(E entity);
}

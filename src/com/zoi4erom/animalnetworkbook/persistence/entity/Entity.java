package com.zoi4erom.animalnetworkbook.persistence.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public abstract class Entity {
	protected final UUID id;
	protected List<String> errors;
	protected Entity(UUID id) {
		errors = new ArrayList<>();
		this.id = id;
	}
	public boolean isValid() {
		return errors.isEmpty();
	}
	public List<String> getErrors() {
		return errors;
	}
	public UUID getId() {
		return id;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Entity entity = (Entity) o;
		return Objects.equals(id, entity.id);
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
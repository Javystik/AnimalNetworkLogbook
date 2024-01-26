package com.zoi4erom.animalnetworkbook.persistence.repository.impl.json;

import com.zoi4erom.animalnetworkbook.persistence.entity.Entity;
import com.zoi4erom.animalnetworkbook.persistence.exception.JsonFileIOException;
import com.zoi4erom.animalnetworkbook.persistence.repository.Repository;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class GenericJsonRepository<E extends Entity> implements Repository<E> {

    protected final Set<E> entities;
    private final Gson gson;
    private final Path path;
    private final Type collectionType;

    public GenericJsonRepository(Gson gson, Path path, Type collectionType) {
        this.gson = gson;
        this.path = path;
        this.collectionType = collectionType;
        entities = new HashSet<>(loadAll());
    }

    @Override
    public Optional<E> findById(UUID id) {
        return entities.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    @Override
    public Set<E> findAll() {
        return entities;
    }

    @Override
    public Set<E> findAll(Predicate<E> filter) {
        return entities.stream().filter(filter).collect(Collectors.toSet());
    }

    @Override
    public E add(E entity) {
        entities.remove(entity);
        entities.add(entity);
        return entity;
    }

    @Override
    public boolean remove(E entity) {
        return entities.remove(entity);
    }

    public Path getPath() {
        return path;
    }

    private Set<E> loadAll() {
        try {
            fileNotFound();
            var json = Files.readString(path);
            return isValidJson(json) ? gson.fromJson(json, collectionType) : new HashSet<>();
        } catch (IOException e) {
            throw new JsonFileIOException("Помилка при роботі із файлом %s."
                    .formatted(path.getFileName()));
        }
    }
    private boolean isValidJson(String input) {
        try (JsonReader reader = new JsonReader(new StringReader(input))) {
            reader.skipValue();
            return reader.peek() == JsonToken.END_DOCUMENT;
        } catch (IOException e) {
            return false;
        }
    }
    private void fileNotFound() throws IOException {
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
    }
}

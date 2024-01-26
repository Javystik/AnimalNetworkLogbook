package com.zoi4erom.animalnetworkbook.persistence.repository.impl.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;
import com.zoi4erom.animalnetworkbook.persistence.entity.Entity;
import com.zoi4erom.animalnetworkbook.persistence.exception.JsonFileIOException;
import com.zoi4erom.animalnetworkbook.persistence.repository.RepositoryFactory;
import com.zoi4erom.animalnetworkbook.persistence.repository.contracts.AnimalRepository;
import com.zoi4erom.animalnetworkbook.persistence.repository.contracts.RequestRepository;
import com.zoi4erom.animalnetworkbook.persistence.repository.contracts.ShelterRepository;
import com.zoi4erom.animalnetworkbook.persistence.repository.contracts.UserRepository;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Set;

/**
 * це реалізація патерну UnitOfWork, та також фабрики з сінглтоном.
 */
public class JsonRepositoryFactory extends RepositoryFactory {

    private final Gson gson;
    private UserJsonRepositoryImpl userJsonRepositoryImpl;
    private AnimalJsonRepositoryImpl animalJsonRepositoryImpl;
    private ShelterJsonRepositoryImpl shelterJsonRepositoryImpl;
    private RequestJsonRepositoryImpl requestJsonRepositoryImpl;
    private JsonRepositoryFactory() {
        // Адаптер для типу даних LocalDateTime при серіалізації/десеріалізації
        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.registerTypeAdapter(LocalDateTime.class,
                (JsonSerializer<LocalDateTime>) (localDate, srcType, context) ->
                        new JsonPrimitive(
                                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm").format(localDate)));
        gsonBuilder.registerTypeAdapter(LocalDateTime.class,
                (JsonDeserializer<LocalDateTime>) (json, typeOfT, context) ->
                        LocalDateTime.parse(json.getAsString(),
                                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")
                                        .withLocale(Locale.of("uk", "UA"))));

        gsonBuilder.registerTypeAdapter(LocalDate.class,
                (JsonSerializer<LocalDate>) (localDate, srcType, context) ->
                        new JsonPrimitive(
                                DateTimeFormatter.ofPattern("dd-MM-yyyy").format(localDate)));
        gsonBuilder.registerTypeAdapter(LocalDate.class,
                (JsonDeserializer<LocalDate>) (json, typeOfT, context) ->
                        LocalDate.parse(json.getAsString(),
                                DateTimeFormatter.ofPattern("dd-MM-yyyy")
                                        .withLocale(Locale.of("uk", "UA"))));

        gson = gsonBuilder.setPrettyPrinting().create();

        userJsonRepositoryImpl = new UserJsonRepositoryImpl(gson);
        animalJsonRepositoryImpl = new AnimalJsonRepositoryImpl(gson);
        shelterJsonRepositoryImpl = new ShelterJsonRepositoryImpl(gson);
        requestJsonRepositoryImpl = new RequestJsonRepositoryImpl(gson);
    }

    public static JsonRepositoryFactory getInstance() {
        return InstanceHolder.INSTANCE;
    }

    @Override
    public UserRepository getUserRepository() {
        return userJsonRepositoryImpl;
    }

    @Override
    public RequestRepository getRequestRepository() {
        return requestJsonRepositoryImpl;
    }

    @Override
    public ShelterRepository getShelterRepository() {
        return shelterJsonRepositoryImpl;
    }

    @Override
    public AnimalRepository getAnimalRepository() {
        return animalJsonRepositoryImpl;
    }

    @Override
    public void commit() {
        serializeEntities(userJsonRepositoryImpl.getPath(), userJsonRepositoryImpl.findAll());
        serializeEntities(animalJsonRepositoryImpl.getPath(), animalJsonRepositoryImpl.findAll());
        serializeEntities(requestJsonRepositoryImpl.getPath(), requestJsonRepositoryImpl.findAll());
        serializeEntities(shelterJsonRepositoryImpl.getPath(), shelterJsonRepositoryImpl.findAll());
    }
    private <E extends Entity> void serializeEntities(Path path, Set<E> entities) {
        try (FileWriter writer = new FileWriter(path.toFile())) {
            writer.write("");
            gson.toJson(entities, writer);

        } catch (IOException e) {
            throw new JsonFileIOException("Не вдалось зберегти дані у json-файл. Детальніше: %s"
                .formatted(e.getMessage()));
        }
    }

    private static class InstanceHolder {
        public static final JsonRepositoryFactory INSTANCE = new JsonRepositoryFactory();
    }
}

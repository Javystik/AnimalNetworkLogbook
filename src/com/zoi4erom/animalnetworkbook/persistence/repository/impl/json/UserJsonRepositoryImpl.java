package com.zoi4erom.animalnetworkbook.persistence.repository.impl.json;

import com.zoi4erom.animalnetworkbook.persistence.entity.User;
import com.zoi4erom.animalnetworkbook.persistence.repository.contracts.UserRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.Optional;
import java.util.Set;

class UserJsonRepositoryImpl extends GenericJsonRepository<User> implements UserRepository{

    public UserJsonRepositoryImpl(Gson gson) {
        super(gson, JsonPathFactory.USERS.getPath(), TypeToken
                .getParameterized(Set.class, User.class)
                .getType());
    }

    @Override
    public Optional<User> findByFullName(String fullName) {
        return entities.stream().filter(u -> u.getFullName().equals(fullName)).findFirst();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return entities.stream().filter(u -> u.getEmail().equals(email)).findFirst();
    }
}

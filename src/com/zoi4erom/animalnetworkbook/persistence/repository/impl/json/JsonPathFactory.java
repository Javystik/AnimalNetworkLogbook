package com.zoi4erom.animalnetworkbook.persistence.repository.impl.json;

import java.nio.file.Path;

public enum JsonPathFactory {
	USERS("users.json"),
	ANIMALS("animals.json"),
	SHELTERS("shelters.json"),
	REQUESTS("requests.json");

	private static final String DATA_DIRECTORY = "data";
	private final String fileName;

	JsonPathFactory(String fileName) {
		this.fileName = fileName;
	}

	public Path getPath() {
		return Path.of(DATA_DIRECTORY, this.fileName);
	}
}

package com.zoi4erom.test;

public class People {
	private final String fullName;
	private final String password;

	private People(String fullName, String password) {
		this.fullName = fullName;
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public String getPassword() {
		return password;
	}

	public static People createUser(String username, String password) {
		if(password.length() <= 3){
			return null;
		}
		return new People(username, password);
	}

	@Override
	public String toString() {
		return "People{" +
		    "fullName='" + fullName + '\'' +
		    ", password='" + password + '\'' +
		    '}';
	}
}

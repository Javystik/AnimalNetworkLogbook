package com.zoi4erom.animalnetworkbook.persistence.validation;

import java.util.regex.Pattern;

public class Validator {
	public static Boolean isFieldBlankValidate(String value){
		return value.isBlank();
	}
	public static Boolean isFieldSizeValidate(String value, int minimumSize, int maximumSize){
		return value.length() > maximumSize && value.length() < minimumSize;
	}
	public static Boolean isFieldOnlyLatinAndCyrillicLettersValidate(String value){
		Pattern latinAndCyrillicLettersPattern = Pattern.compile("^[a-zA-Zа-яА-Я]+([\\s-'][a-zA-Zа-яА-Я]+)*$");
		return !latinAndCyrillicLettersPattern.matcher(value).matches();
	}
	public static Boolean isFieldPasswordValidate(String password) {
		Pattern validPasswordPattern = Pattern.compile("^[a-zA-Z0-9]+$");
		return !validPasswordPattern.matcher(password).matches();
	}
}

package com.example.exception;

import org.javalite.activejdbc.InitException;

import com.example.model.Person;

public class PersonException extends Throwable {

	private static <PersonEception extends Person> Class<PersonEception> personClass() {
		  throw new InitException("failed to determine Model class name, are you sure models have been instrumented?");
		}
}

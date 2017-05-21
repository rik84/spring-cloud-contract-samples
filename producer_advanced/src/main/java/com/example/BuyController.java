package com.example;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Marcin Grzejszczak
 */
@RestController
class BuyController {

	//remove::start[]
	@PostMapping(value = "/buy",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	Response buy(@RequestBody Person person) {
		return new Response(Status.NOT_OK, "You're drunk [" + person.name + "]. Go home!");
	}
	//remove::end[]
}

class Person {
	public String name;
	public Integer age;
}

class Response {
	public Status status;
	public String message;

	public Response(Status status, String message) {
		this.status = status;
		this.message = message;
	}

	public Response() {
	}
}

enum Status {
	OK, NOT_OK
}

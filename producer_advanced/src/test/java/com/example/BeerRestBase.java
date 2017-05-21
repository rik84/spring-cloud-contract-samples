package com.example;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;

import org.assertj.core.api.BDDAssertions;
import org.junit.Before;

public abstract class BeerRestBase {

	@Before
	public void setup() {
		//remove::start[]
		RestAssuredMockMvc.standaloneSetup(new StoutController(), new BuyController());
		//remove::end[]
	}

	//remove::start[]
	protected void assertStatus(String status) {
		BDDAssertions.then(status).isEqualToIgnoringCase(Status.NOT_OK.name());
	}
	//remove::end[]
}
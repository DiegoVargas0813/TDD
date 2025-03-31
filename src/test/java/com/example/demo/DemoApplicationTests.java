package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	//It should respond with a JSON representation of a greeting
	@Test
	public void testGreeting() throws Exception {
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/greeting")
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();

		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus(), "Validate endpoint return 200 OK status");
		assertTrue(mvcResult.getResponse().getContentAsString().contains("Hello, World!"), "Validate endpoint response contains 'Hello, World!'");
	}

	//Users should have the option to customize the greeting with an optional ‘name’ parameter in the query string
	@Test
	public void testGreetingOptionalQueryStringParam() throws Exception {
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/greeting").accept(MediaType.APPLICATION_JSON)
				.param("name", "User"))
				.andReturn();

		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus(), "Validate endpoint return 200 OK status");
		assertTrue(mvcResult.getResponse().getContentAsString().contains("Hello, User!"), "Validate endpoint response contains 'Hello, User!'");
	}
}

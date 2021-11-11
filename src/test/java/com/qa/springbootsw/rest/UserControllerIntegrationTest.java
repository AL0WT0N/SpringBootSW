package com.qa.springbootsw.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.springbootsw.domain.User;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // loads context and boots up on different port
@AutoConfigureMockMvc // tells Spring to setup the mockmvc object
@ActiveProfiles("test") // sets the active profile to 'test'
//runs the sql files before each test method
@Sql(scripts = { "classpath:user-schema.sql",
		"classpath:user-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class UserControllerIntegrationTest {

	@Autowired // tells spring to inject in the mockmvc object
	private MockMvc mvc; // library that performs the requests

	@Autowired
	private ObjectMapper mapper; // the actual object Spring uses to convert Java <-> JSON

	@Test
	void testCreate() throws Exception {
		// body, method, content-type, url
		User me = new User("Jordan", "Harrison", "JHarry");
		String meAsJSON = this.mapper.writeValueAsString(me);
		RequestBuilder request = post("/user/create").contentType(MediaType.APPLICATION_JSON).content(meAsJSON);

		ResultMatcher checkStatus = status().isCreated(); // matcher that we will use to test the response

		User meSaved = new User(2, "Jordan", "Harrison", "JHarry");
		String meSavedAsJSON = this.mapper.writeValueAsString(meSaved);

		ResultMatcher checkBody = content().json(meSavedAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void testCreate2() throws Exception {
		// body, method, content-type, url
		User me = new User("Jordan", "Harrison", "JHarry");
		String meAsJSON = this.mapper.writeValueAsString(me);
		RequestBuilder request = post("/user/create").contentType(MediaType.APPLICATION_JSON).content(meAsJSON);

		ResultMatcher checkStatus = status().isCreated(); // matcher that we will use to test the response

		User meSaved = new User(2, "Jordan", "Harrison", "JHarry");
		String meSavedAsJSON = this.mapper.writeValueAsString(meSaved);

		ResultMatcher checkBody = content().json(meSavedAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void testGet() throws Exception {
		User jb = new User(1, "jordan", "benbelaid", "jbizzle");
		String jbAsJSON = this.mapper.writeValueAsString(jb);
		RequestBuilder request = get("/user/getById/1");

		ResultMatcher checkStatus = status().isOk();

		ResultMatcher checkBody = content().json(jbAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testGetAll() throws Exception {
		User jb = new User(1, "jordan", "benbelaid", "jbizzle");
		String usersJSON = this.mapper.writeValueAsString(List.of(jb));
		RequestBuilder request = get("/user/getAll");

		ResultMatcher checkStatus = status().isOk();

		ResultMatcher checkBody = content().json(usersJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testGetByUsername() throws Exception {
		User jb = new User(1, "jordan", "benbelaid", "jbizzle");
		String jbAsJSON = this.mapper.writeValueAsString(jb);
		RequestBuilder request = get("/user/getByUsername/" + jb.getUsername());

		ResultMatcher checkStatus = status().isOk();

		ResultMatcher checkBody = content().json(jbAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testUpdate() throws Exception {
		User me = new User("Jordan", "Harrison", "JHarry");
		String meAsJSON = this.mapper.writeValueAsString(me);
		RequestBuilder request = put("/user/update/1").contentType(MediaType.APPLICATION_JSON).content(meAsJSON);

		ResultMatcher checkStatus = status().isAccepted(); // matcher that we will use to test the response

		User meSaved = new User(1, "Jordan", "Harrison", "JHarry");
		String meSavedAsJSON = this.mapper.writeValueAsString(meSaved);

		ResultMatcher checkBody = content().json(meSavedAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete("/user/delete/1")).andExpect(status().isNoContent());
	}

}

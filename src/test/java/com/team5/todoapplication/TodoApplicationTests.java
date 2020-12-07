package com.team5.todoapplication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class TodoApplicationTests {

	@Autowired
	MockMvc mvc;

	@Test
	void contextLoads() {

		}

	@Test
	public void testGetTodos() throws Exception {
		mvc.perform(
				MockMvcRequestBuilders.get("/todos/")
		)
				.andExpect(status().is2xxSuccessful());
				//.andExpect(MockMvcResultMatchers.content().string(containsString("Shop groceries")));


	}
	}



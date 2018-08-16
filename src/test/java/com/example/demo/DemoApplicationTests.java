package com.example.demo;

import com.example.web.UserController;
import com.example.web.demo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	private MockMvc mockMvc;

	@Before
	public void setUp()throws Exception{
		mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
	}

//	@Test
//	public void contextLoads()throws Exception {
//		mockMvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk())
//				.andExpect(content().string(equalTo("hello,world")));
//	}

	@Test
	public void testUserController()throws Exception{
		RequestBuilder request = null;

		request = get("/user/");
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("[]")));

//		request = post("/user/").param("id","1").param("name","xiaoc").param("age","9");
//		mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("success")));


	}

}

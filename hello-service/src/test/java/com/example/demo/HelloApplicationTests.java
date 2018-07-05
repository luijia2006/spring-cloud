/*
package com.example.demo;

import com.example.demo.controller.HelloController;
import jdk.net.SocketFlow;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloApplicationTests {
	private MockMvc mvc;

	@Before
	public void setUp() {
		mvc= MockMvcBuilders.standaloneSetup(new HelloController()).build();
	}

	@Test
	public void hello() throws Exception {
		ResultActions perform = mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON));
	}

}
*/

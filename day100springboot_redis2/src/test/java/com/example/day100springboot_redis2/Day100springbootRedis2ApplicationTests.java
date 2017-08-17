package com.example.day100springboot_redis2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration
@SpringBootTest
public class Day100springbootRedis2ApplicationTests {

	@Autowired
	WebApplicationContext context;

	MockMvc mockMvc;

	@Before
	public void init(){
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	@Test
	public void contextLoads() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.post("/add")
				.param("id","1")
				.param("name","zhangsan")
		        .param("password","123456")).andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void findAll() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.post("/find")).andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void findName() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.get("/findName")
				.param("name","zhangsan")).andDo(MockMvcResultHandlers.print());
	}
}

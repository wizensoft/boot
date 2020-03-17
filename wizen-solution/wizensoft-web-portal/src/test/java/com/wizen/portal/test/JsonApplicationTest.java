package com.wizen.portal.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wizen.web.portal.model.TestUser;

@SpringBootTest
public class JsonApplicationTest {

	@Test
	void hello() throws JsonProcessingException{
		System.out.println("JsonApplicationTest test");
		
		TestUser testUser =new TestUser();
		testUser.setRegId("ksr id");
		testUser.setBoardIdx(123);
		testUser.setTitle("aaaaa");
		ObjectMapper objectMapper = new ObjectMapper();
		String modelString = objectMapper.writeValueAsString(testUser);
		System.out.println("modelString ="  +modelString);
		TestUser user = objectMapper.readValue(modelString, TestUser.class);
		System.out.println("user.getRegId ="  +user.getRegId());
		
		//Assertions.assertThat(helloService.hello("안녕")).isEqualTo("안녕");
	}
}

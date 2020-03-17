package com.wizen.portal.test;

//import static org.hamcrest.Matchers.equalTo;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import org.apache.taglibs.standard.tag.common.core.SetSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.context.TestPropertySource;

import com.wizen.web.portal.model.TestUser;
import com.wizen.web.portal.services.HelloService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;
import java.util.Set;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@SpringBootTest
//@TestPropertySource(locations = "/foo.properties")
//@AutoConfigureMockMvc
public class SimpleRedisUnitTest {

	@Autowired
	HelloService helloService;
	
	@Autowired
	RedisTemplate redisTemplate;

	@DisplayName("Test Spring @Autowired Integration")
	@Test
	void testGet() {
		System.out.println("Hello JUnit 5 ##");
		//Set<byte[]> keys = redisTemplate.keys("*");
		// value operation
		ValueOperations<String, Object> values = redisTemplate.opsForValue();

		Set<String> redisKeys = redisTemplate.keys("*");
		// Store the keys in a List
		//List<String> keysList = new ArrayList<>();
		Iterator<String> it = redisKeys.iterator();
		while (it.hasNext()) {
		       String data = it.next();
		       System.out.println("data a = " + data);
		       //keysList.add(data);
		}
		TestUser testUser =new TestUser();
		testUser.setBoardIdx(1);
		testUser.setContent("cc");
		testUser.setRegId("rreg11");
		values.set("user111", testUser);

		
		//System.out.println("a ==" + values.get("a"));
		if (redisTemplate.hasKey("c")) {
			System.out.println("c exists b");
			values.set("c", "cc cc11");
			System.out.println("c ==" + values.get("c"));
			
			values.set("ksr11", "test cc11");
			System.out.println("ksr11 ==" + values.get("ksr11"));

			values.set("ksr33", "test cc33");
			System.out.println("ksr33 ==" + values.get("ksr33"));

			
		} else {
			System.out.println("c not exists");
			values.set("ksr11", "test cc");
			
		}
		
		
		
		//redisTemplate.opsForSet()
		System.out.println("Employee added a : " + values.get("c"));			
		System.out.println("Employee added b: " + values.get("ksr11"));
		
		
		////case b
		String key2="c";
		String IP = "192.168.0.10";
		int PORT = 6379;
		int TIME_OUT = 1000;
		String PASSWORD = "";
		
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		
		//JedisPool pool = new JedisPool(jedisPoolConfig , IP , PORT , TIME_OUT , PASSWORD );
		JedisPool pool = new JedisPool(jedisPoolConfig , IP , PORT , TIME_OUT );
		
		Jedis jedis = pool.getResource();
		Set<String> redisKeys2  = jedis.keys("*");
		Iterator<String> it2 = redisKeys2.iterator();
		while (it2.hasNext()) {
		       String data = it2.next();
		       System.out.println("data b = " + data);
		       //keysList.add(data);
		}
		

		jedis.set(key2, "cccaaaa");
		System.out.println(key2 +" = " + jedis.get(key2));
		//if(id.equals("a")) {
			//pool.close();
			//logger.debug("pointRedisRepository.count() ::: " +redisTemplate.boundValueOps(pwd) );
			
			//Point savedPoint = pointRedisRepository.findById(pwd).get();
			//String savedPoint = pointRedisRepository.findById(pwd).get();
			//logger.debug("savedPoint a ::: " +savedPoint.getValue() );
			//logger.debug("savedPoint.getAmount() ::: " +savedPoint.getAmount() );
		//} else {
			//logger.debug("id b ::: " +pwd );

		        //when
		        //pointRedisRepository.save(point);
		    
		//}
		if (jedis != null) {
			jedis.close();
			jedis = null;
		}
		
		
		
		assertEquals("Hello JUnit 5", helloService.get());
		
		
	}
	
	/*
	 * 
	 * @Test public void indexTest() throws Exception {
	 * mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON
	 * )) // "/" 에 대한 request 요청 .andExpect(status().isOk()) // response 가 200 ok 일때
	 * .andExpect(content().string(equalTo("Greetings from Spring Boot!"))); //
	 * response로 받은 데이터가 같은지 확인 }
	 * 
	 * @Test public void helloTest() throws Exception {
	 * mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.
	 * APPLICATION_JSON)) // "/hello" 에 대한 request 요청 .andExpect(status().isOk()) //
	 * response 가 200 ok 일때 .andExpect(content().string(equalTo("Hello world"))); //
	 * response로 받은 데이터가 같은지 확인 } }
	 */

}

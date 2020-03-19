package com.wizen.web.portal.pages;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wizen.core.Test;
import com.wizen.web.portal.model.TestUser;
import com.wizen.web.portal.services.TestUserService;
import com.wizen.web.portal.services.redis.Point;
import com.wizen.web.portal.services.redis.PointRedisRepository;

//import com.wizen.core.Test;
import lombok.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Controller
public class MainController {

	//private Log logger;
	private Log logger = LogFactory.getLog(getClass());;
	
	@Autowired
	private TestUserService testUserService;
	
	@SuppressWarnings("rawtypes")
	@Autowired
	RedisTemplate redisTemplate;
	
	//@Autowired
    //private RedisTemplate redisTemplate;
	
	@RequestMapping("/main/home.do")
	//@RequestMapping(value = "/loginCheck", method = RequestMethod.GET) 
	public String home(@RequestParam("gubun") String gubun
			,@RequestParam("key") String key
			,@RequestParam("value") String value) {
		logger.debug("url call ====/main/home.do #########");
		/*
redis 등록수정 삭제 테스트
http://localhost:8080/wizensoft-web-portal/main/home.do?gubun=list&key=a&value=a
http://localhost:8080/wizensoft-web-portal/main/home.do?gubun=view&key=user111&value=a
http://localhost:8080/wizensoft-web-portal/main/home.do?gubun=upd&key=user111&value=bbbb
http://localhost:8080/wizensoft-web-portal/main/home.do?gubun=del&key=ksr33&value=a
		 */
		
		logger.debug("gubun = " +gubun ); 
		logger.debug("key == " +key );
		logger.debug("value = " +value );
		
		
		if(gubun.equals("set") || gubun.equals("upd")){
			if(redisTemplate.hasKey(key)) {
				logger.debug("redis exists key = " +key );
			} else {
				logger.debug("redis no exists key = " +key );
			}
			ValueOperations<String, Object> values = redisTemplate.opsForValue();
			// update 
			TestUser testUser =new TestUser();
			testUser.setBoardIdx(1);
			testUser.setContent("cc");
			testUser.setRegId(key +"-regid-" +value);
			values.set(key, testUser);
		} else if(gubun.equals("view")){
			if(redisTemplate.hasKey(key)) {
				logger.debug("view data key= " +key );
				// redis에서 data delete
				TestUser testUser = (TestUser)redisTemplate.opsForValue().get(key);
				logger.debug("view data getRegId = " +testUser.getRegId() );
			} else {
				logger.debug("view  no data key = " +key );
			}
		} else if(gubun.equals("del")){
			if(redisTemplate.hasKey(key)) {
				logger.debug("redis data 삭제 key= " +key );
				// redis에서 data delete
		        redisTemplate.delete(key);
			} else {
				logger.debug("삭제하려는데 키가 없음 = " +key );
			}
		} else {
			// list
			Set<String> redisKeys = redisTemplate.keys("*");
			// Store the keys in a List
			//List<String> keysList = new ArrayList<>();
			Iterator<String> it = redisKeys.iterator();
			while (it.hasNext()) {
			       String data = it.next();
			       System.out.println("data a = " + data);
			       //keysList.add(data);
			}
		}

		
		
		
		return "main/home";
	}
	@RequestMapping("/main/home2.do")
	public ModelAndView home2() {
		logger.debug("url call ====/main/home2.do #########");
ModelAndView mav = new ModelAndView("main/home2");
        
        mav.addObject("key", "과일");
        
        List<String> fruitList = new ArrayList<String>();
        
        fruitList.add("apple");
        fruitList.add("orange");
        fruitList.add("banana");
        
       com.wizen.core.Test test =new Test();
        fruitList.add(test.getInfo());
      
        mav.addObject("value", fruitList);
		return mav;
	}
	
	@RequestMapping("/main/index.do")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("main/index.sharedtiles");
		logger.debug("portal url call ====/main/index.do #########");
		String totalCnt = this.testUserService.selectTestMapper(135);
		mv.addObject("totalCnt", totalCnt);
		//mv.addObject("list", list);
		//mv.addObject("boardDto", boardDto);
		
		return mv;
	}
	@RequestMapping("/main/index2.do")
	public String index2() {
		return "main/index2.sharedtilesbody";
	}
	
	@RequestMapping("/main/index3.do")
	public ModelAndView index3() {
		logger.debug("url call ====/main/index3.do #########");
		ModelAndView mav = new ModelAndView("main/index3.tilesbody");
        
        mav.addObject("key", "fruits");
        
        List<String> fruitList = new ArrayList<String>();
        
        fruitList.add("apple");
        fruitList.add("orange");
        fruitList.add("banana");
        
       com.wizen.core.Test test =new Test();
        fruitList.add(test.getInfo());
      
        mav.addObject("value", fruitList);
        //mav.setViewName("main/index3.tilesbody");
		return mav;
	}
	
	
	//
}

package com.wizen.web.portal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wizen.web.portal.mapper.TestUserMapper;

@Service
public class TestUserServiceImpl implements TestUserService {
	 @Autowired
    private TestUserMapper testUserMapper;
	 
	 public String selectTestMapper(int number) {
		 
		 String ss= testUserMapper.selectTestMapper(number);
		 ///ddf
		 
		 // ddd
		 return ss;
	 }
	 
}

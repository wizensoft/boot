package com.wizen.web.portal.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestUserMapper {

	//@Select("SELECT * from lettnauthorinfo WHERE author_code='ROLE_ADMIN'")
	String selectTestMapper(int number);
	
}

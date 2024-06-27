package com.quiz.lesson06.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson06.domain.Url;

@Mapper
public interface UrlMapper {

	public void insertUrl(
			@Param("name") String name, 
			@Param("url") String url);
	
	public List<Url> selectUrlList();
}

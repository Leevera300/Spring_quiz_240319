package com.quiz.lesson06.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UrlMapper {

	public void insertUrl(String name, String url);
}

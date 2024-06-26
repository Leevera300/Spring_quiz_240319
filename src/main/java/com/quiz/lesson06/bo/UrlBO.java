package com.quiz.lesson06.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.mapper.UrlMapper;

@Service
public class UrlBO {

	@Autowired
	private UrlMapper urlMapper;
	
	public void addUrl(String name, String url) {
		urlMapper.insertUrl(name, url);
	}
}

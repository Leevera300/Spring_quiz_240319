package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.domain.Url;
import com.quiz.lesson06.mapper.UrlMapper;

@Service
public class UrlBO {

	@Autowired
	private UrlMapper urlMapper;
	
	public void addUrl(String name, String url) {
		urlMapper.insertUrl(name, url);
	}
	
	// input: X
	// output: List<Url>
	public List<Url> getUrlList() {
		return urlMapper.selectUrlList();
	}
}

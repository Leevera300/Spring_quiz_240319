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
	
	// input: url
	// output: boolean
	public boolean getisDuplicationByUrl(String url) {
		// 중복 [url1, url2] true		중복 아님: [] false
		List<Url> bookmarkList = urlMapper.selectUrlListByUrl(url);
		// return bookmarkList.isEmpty() ? false : true; // 비어있음 false 아니면 true
		return !bookmarkList.isEmpty();
	}
	
	public int deleteUrlById(int id) {
		return urlMapper.deleteUrlById(id);
	}
}

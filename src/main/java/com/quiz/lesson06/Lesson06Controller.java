package com.quiz.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson06.bo.UrlBO;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Controller {

	@Autowired
	private UrlBO urlBO;
	
	@GetMapping("/add-url-view")
	public String addUrlView() {
		return "lesson06/addUrl";
	}
	
	@PostMapping("/add-url")
	public String addUrl(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		
		// DB insert
		urlBO.
		// return
		return "success";
	}
	
	@GetMapping("/url-list-view")
	public String urlListView() {
		return "lesson06/urlList";
	}
}

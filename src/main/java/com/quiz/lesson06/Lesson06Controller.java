package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.UrlBO;
import com.quiz.lesson06.domain.Url;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Controller {

	@Autowired
	private UrlBO urlBO;
	
	@GetMapping("/add-url-view")
	public String addUrlView() {
		return "lesson06/addUrl";
	}
	
	// AJAX
	@ResponseBody
	@PostMapping("/add-url")
	public Map<String, Object> addUrl(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		
		// DB insert
		urlBO.addUrl(name, url);
		// return
		// 성공 JSON
		// {"code":200, "result":"성공"}
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		return result; // JSON String
	}
	
	@GetMapping("/url-list-view")
	public String urlListView(Model model) {
		//select
		List<Url> BookMark = urlBO.getUrlList();
		//Model
		model.addAttribute("BookMark", BookMark);
		
		return "lesson06/urlList";
	}
	
	@ResponseBody
	@GetMapping("/is-duplication-url")
	public Map<String, Object> isDuplicationUrl() {
		
	}
}

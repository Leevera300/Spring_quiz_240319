package com.quiz.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lesson01Quiz03Controller {

	@RequestMapping("/lesson01/quiz03")
	public String quiz03() {
		// @ResponseBody가 아닌 상태로 return String을 함녀
		// ViewResolver에 의해 리턴된 HTML 경로를 찾아 화면이 구성된다
		return "lesson01/quiz03"; // html 경로
	}
}

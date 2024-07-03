package com.quiz.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.entity.HiringEntity;
import com.quiz.lesson07.repository.HiringRepository;

@RequestMapping("/lesson07/quiz02")
@RestController
public class Lesson07Quiz02RestController {

	@Autowired
	private HiringRepository hiringrepository;
	
	@GetMapping("/1")
	public HiringEntity one() {
		return hiringrepository.findById(8).orElse(null);
	}
	
	@GetMapping("/2")
	public List<HiringEntity> two() {
		return hiringrepository.findByCompanyId(1);
	}
	
	@GetMapping("/3")
	public List<HiringEntity> three() {
		return hiringrepository.findByPositionAndType("웹 back-end 개발자", "정규직");
	}
}

package com.quiz.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		// new HiringEntity() == null 인데 이것저것 보여줌
	}
	
	// /lesson07/quiz02/2?companyId=1
	@GetMapping("/2")
	public List<HiringEntity> two(
			@RequestParam("companyId") int companyId) {
		
		return hiringrepository.findByCompanyId(companyId);
	}
	
	// /lesson07/quiz02/3
	@GetMapping("/3")
	public List<HiringEntity> three() {
		return hiringrepository.findByPositionAndType("웹 back-end 개발자", "정규직");
	}
	
	// /lesson07/quiz02/4
	@GetMapping("/4")
	public List<HiringEntity> four() {
		return hiringrepository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);
	}
	
	// /lesson07/quiz02/5
	@GetMapping("/5")
	public List<HiringEntity> five() {
		return hiringrepository.findTop3ByTypeOrderBySalaryDesc("계약직");
	}
	
	// /lesson07/quiz02/6
	@GetMapping("/6")
	public List<HiringEntity> six() {
		// return hiringrepository.findByRegionAndSalaryGreaterThanEqualAndSalaryLessThanEqual("성남시 분당구", 7000, 8500);
		return hiringrepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
	}
	
	// /lesson07/quiz02/7
	// 마감일이 2026-04-10 이후이고 연봉이 8100 이상인 정규직 공고를 연봉 내림차순으로 조회하세요.
	@GetMapping("/7")
	public List<HiringEntity> seven() {
		// return hiringrepository.findByTypeAndDeadlineGreaterThanEqualAndSalaryGreaterThanEqualOrderBySalaryDesc("정규직", "2026-04-10", 8100);
		return hiringrepository.findByDeadlineAndSalaryAndType("2026-04-10", 8100, "정규직");
	}
	
}

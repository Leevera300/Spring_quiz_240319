package com.quiz.lesson07.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.repository.HiringRepository;

@Service
public class HiringBO {

	@Autowired
	private HiringRepository hiringrepository;
}

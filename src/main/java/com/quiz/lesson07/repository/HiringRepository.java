package com.quiz.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.lesson07.entity.HiringEntity;

public interface HiringRepository extends JpaRepository<HiringEntity, Integer>{

	public List<HiringEntity> findByCompanyId(int cId);
	public List<HiringEntity> findByPositionAndType(String position, String type);
}

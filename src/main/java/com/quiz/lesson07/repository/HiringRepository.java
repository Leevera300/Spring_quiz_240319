package com.quiz.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quiz.lesson07.entity.HiringEntity;

public interface HiringRepository extends JpaRepository<HiringEntity, Integer>{

	// JPQL => Entity 조회
	// quiz02_02
	public List<HiringEntity> findByCompanyId(int companyId);
	// quiz02_03
	public List<HiringEntity> findByPositionAndType(String position, String type);
	// quiz02_04
	public List<HiringEntity> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
	// quiz02_05
	public List<HiringEntity> findTop3ByTypeOrderBySalaryDesc(String type);
	// quiz02_06
	public List<HiringEntity> findByRegionAndSalaryGreaterThanEqualAndSalaryLessThanEqual(String region, int startSalary, int endSalary);
	public List<HiringEntity> findByRegionAndSalaryBetween(String region, int startSalary, int endSalary);
	// quiz02_07s
//	@Query(value = "select * from `hiring` where `type` = :type and `deadline` >= :deadline and `salary` >= :salary Order By `salary` DESC", nativeQuery = true)
//	public List<HiringEntity> findByTypeAndDeadlineGreaterThanEqualAndSalaryGreaterThanEqualOrderBySalaryDesc(
//			@Param("type") String type, 
//			@Param("deadline") String deadline, 
//			@Param("salary") int salary);
	// quiz02 7 번 - native query (DB에 직접 SQL)
	@Query(value = "select * from `hiring` "
			+ "where `deadline` >= :deadline "
			+ "and `salary` >= :salary "
			+ "and `type` = :type "
			+ "order By `salary` DESC", 
			nativeQuery = true)
	public List<HiringEntity> findByDeadlineAndSalaryAndType(
			@Param("deadline") String deadline, 
			@Param("salary") int salary,
			@Param("type") String type);
	
	
}

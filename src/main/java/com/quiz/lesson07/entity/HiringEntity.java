package com.quiz.lesson07.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString 
@AllArgsConstructor 
@NoArgsConstructor 
@Builder(toBuilder = true) 
@Getter
@Table(name = "hiring")
@Entity
public class HiringEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "companyId")
	private int companyId;
	
	private String position;
	
	private String responsibilities;
	
	private String qualification;
	
	private String type;
	
	private String region;
	
	private int salary;
	
	private LocalDate deadline;
	
	@CreationTimestamp // 시간값이 없어도 현재시간으로 들어감, 업데이트시 변경 X
	@Column(name = "createdAt")
	private LocalDateTime createdAt;
	
	@UpdateTimestamp // 업데이트시 변경 O
	@Column(name = "updatedAt")
	private LocalDateTime updatedAt;
}

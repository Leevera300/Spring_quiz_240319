package com.quiz.lesson07.entity;

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

@ToString // 객체 출력시 필드 값들이 보인다.
@AllArgsConstructor // 모든 파라미터 있는 생성자
@NoArgsConstructor // 파라미터 없는 생성자
@Builder // setter를 대슨해서 내용을 담음
@Getter
@Table(name = "company")
@Entity // 이 객체는 엔티티다. BO-JPA-DB
public class CompanyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String business;
	
	private String scale;
	
	private int headcount;
	
	@CreationTimestamp // 시간값이 없어도 현재시간으로 들어감, 업데이트시 변경 X
	@Column(name = "createdAt")
	private LocalDateTime createdAt;
	
	@UpdateTimestamp // 업데이트시 변경 O
	@Column(name = "updatedAt")
	private LocalDateTime updatedAt;
}

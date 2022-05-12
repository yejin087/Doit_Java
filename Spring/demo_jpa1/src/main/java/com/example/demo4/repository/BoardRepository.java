package com.example.demo4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo4.model.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	public void deleteByNum(Long num); // 쿼리메서드

}

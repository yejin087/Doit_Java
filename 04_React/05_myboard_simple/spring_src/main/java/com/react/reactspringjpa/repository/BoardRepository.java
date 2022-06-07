package com.react.reactspringjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.react.reactspringjpa.model.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}

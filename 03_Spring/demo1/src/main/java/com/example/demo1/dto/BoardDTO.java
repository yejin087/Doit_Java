package com.example.demo1.dto;

import java.util.Date;

import lombok.Data;

@Data // getter, setter, constructor 등 자동 생성
public class BoardDTO {
	private int num; // 번호
	private String title; // 제목
	private String writer; // 작성자
	private String content; // 내용
	private Date regdate; // 작성일
	private int hitcount; // 조회수
	private int replyCnt; // 댓글 개수
}

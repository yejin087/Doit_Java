package com.myspring.dto;

import java.util.Date;

import lombok.Data;

@Data // getter, setter, constructor �� �ڵ� ����
public class BoardDTO {
	private int num; // ��ȣ
	private String title; // ����
	private String writer; // �ۼ���
	private String content; // ����
	private Date regdate; // �ۼ���
	private int hitcount; // ��ȸ��
	private int replyCnt; // ��� ����
}

package com.mybatis.model;

import java.util.List;

import lombok.Getter;

// @ResponseBody�� ����ؼ� ��ȯ�� ����� ���� ��ȯ�� ���� class
@Getter
public class GuestListVO {
	private List<GuestVO> guest_list;
	private int count;

	public GuestListVO(List<GuestVO> guest_list, int count) {
		this.guest_list = guest_list;
		this.count = count;
	}

}

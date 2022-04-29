package com.mybatis.model;

import java.util.List;

import lombok.Getter;

// @ResponseBody를 사용해서 반환할 사용자 정의 반환값 저장 class
@Getter
public class GuestListVO {
	private List<GuestVO> guest_list;
	private int count;

	public GuestListVO(List<GuestVO> guest_list, int count) {
		this.guest_list = guest_list;
		this.count = count;
	}

}

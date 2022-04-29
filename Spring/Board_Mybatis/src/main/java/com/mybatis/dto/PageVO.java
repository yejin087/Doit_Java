package com.mybatis.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageVO {
	private int totPage;
	private int blockPage;
	private int startPage; // 페이지 시작 번호
	private int endPage;
	private int currentPage;
	private String field;
	private String word;

	public PageVO(int count, int currentPage, int pageSize) {
		this.totPage = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		this.blockPage = 3;
		this.startPage = ((currentPage - 1) / blockPage * blockPage + 1);
		this.endPage = startPage + blockPage - 1;
		if (endPage > totPage)
			this.endPage = totPage;
		this.currentPage = currentPage;
	}

}

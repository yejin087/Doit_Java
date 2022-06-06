package com.mybatis.model;

import java.util.HashMap;
import java.util.List;

public interface GuestService {
	// insert
	public void guestInsert(GuestVO guest);

	// list all
	public List<GuestVO> guestList(HashMap<String, String> hm);

	// view detail
	public GuestVO findByNum(int num);

	// update
	public void guestUpdate(GuestVO guest);

	// delete
	public void guestDelete(int num);

	// count
	public int guestCount(HashMap<String, String> hm);
}

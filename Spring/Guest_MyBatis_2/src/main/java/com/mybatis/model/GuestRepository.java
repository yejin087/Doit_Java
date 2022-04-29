package com.mybatis.model;

import java.util.HashMap;
import java.util.List;

public interface GuestRepository {
	// insert
	public void dao_guestInsert(GuestVO guest);

	// list
	public List<GuestVO> dao_guestList(HashMap<String, String> hm);

	// view
	public GuestVO dao_findByNum(int num);

	// update
	public void dao_guestUpdate(GuestVO guest);

	// delete
	public void dao_guestDelete(int num);

	// count
	public int dao_guestCount(HashMap<String, String> hm);
}

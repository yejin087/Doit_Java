package com.myguest.model;

import java.util.HashMap;
import java.util.List;

public interface GuestDAO {
	// insert
	public void dao_guestInsert(String mid, GuestDTO guest);

	// list
	public List<GuestDTO> dao_guestList(String mid, HashMap<String, String> hm);

	// view
	public GuestDTO dao_findByNum(String mid, int num);

	// update
	public void dao_guestUpdate(String mid, GuestDTO guest);

	// delete
	public void dao_guestDelete(String mid, int num);

	// count
	public int dao_guestCount(String mid, HashMap<String, String> hm);
}

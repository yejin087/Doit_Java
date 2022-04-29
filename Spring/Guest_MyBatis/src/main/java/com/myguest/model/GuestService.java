package com.myguest.model;

import java.util.HashMap;
import java.util.List;

public interface GuestService {
	// insert
	public void guestInsert(GuestDTO guest);

	// list all
	public List<GuestDTO> guestList(HashMap<String, String> hm);

	// view detail
	public GuestDTO findByNum(int num);

	// update
	public void guestUpdate(GuestDTO guest);

	// delete
	public void guestDelete(int num);

	// count
	public int guestCount(HashMap<String, String> hm);
}

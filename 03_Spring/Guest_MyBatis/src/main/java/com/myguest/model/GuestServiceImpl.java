package com.myguest.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements GuestService {

	// 어떻게 동작ㄷ됏지.. dao 없는데..
	@Autowired
	private GuestDAOImpl dao;

	@Override
	public void guestInsert(GuestDTO guest) {
		dao.dao_guestInsert("guest_insert", guest);
	}

	@Override
	public List<GuestDTO> guestList(HashMap<String, String> hm) {

		return dao.dao_guestList("guest_list", hm);
	}

	@Override
	public GuestDTO findByNum(int num) {

		return dao.dao_findByNum("guest_view", num);
	}

	@Override
	public void guestUpdate(GuestDTO guest) {

		dao.dao_guestUpdate("guest_update", guest);

	}

	@Override
	public void guestDelete(int num) {

		dao.dao_guestDelete("guest_delete", num);

	}

	@Override
	public int guestCount(HashMap<String, String> hm) {

		return dao.dao_guestCount("guest_count", hm);
	}

}

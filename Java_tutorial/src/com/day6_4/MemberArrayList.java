package com.day6_4;

import java.util.ArrayList;

public class MemberArrayList {

	private ArrayList<Member> arraylist;

	public MemberArrayList() {
		arraylist = new ArrayList<Member>();

	}

	public void addMember(Member mem) {
		arraylist.add(mem);
	}

	public boolean removeMember(int memberId) {
		for (int i = 0; i < arraylist.size(); i++) {
			Member member = arraylist.get(i);
			int tmpId = member.getMemberId();
			if (tmpId == memberId) {
				arraylist.remove(i);
				return true;
			}
		}

		System.out.println(memberId + "doesn't exits");
		return false;
	}

	public void showAllMember() {
		for (Member member : arraylist) {
			System.out.println(member);
		}

		System.out.println();
	}
}

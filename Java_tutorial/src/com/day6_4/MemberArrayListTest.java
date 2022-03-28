package com.day6_4;

public class MemberArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberArrayList memberArrayList = new MemberArrayList();

		Member memberLee = new Member(1001, "jiwon");
		Member memberSon = new Member(1002, "son");
		Member memberPark = new Member(1003, "park");
		Member memberHong = new Member(1004, "hong");

		memberArrayList.addMember(memberLee);
		memberArrayList.addMember(memberSon);
		memberArrayList.addMember(memberPark);
		memberArrayList.addMember(memberHong);

		memberArrayList.showAllMember();
	}

}

package com.day7_1;

public class MemberHashMapTest {

  public static void main(String[] args) {
    MemberHashMap memhash = new MemberHashMap();

    Member memberLee = new Member(1001, "jiwon");
    Member memberSon = new Member(1002, "son");
    Member memberPark = new Member(1003, "park");
    Member memberHong = new Member(1004, "hong");

    memhash.addMember(memberLee);
    memhash.addMember(memberSon);
    memhash.addMember(memberPark);
    memhash.addMember(memberHong);

    memhash.showAllMember();

    Member flag = memhash.removeMember(1001);
    System.out.println("remove " + flag);
    memhash.showAllMember();
  }
}

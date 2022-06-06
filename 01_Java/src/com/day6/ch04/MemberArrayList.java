package com.day6.ch04;

import java.util.ArrayList;
import java.util.Iterator;

import com.day7.ch01.IteratorEx1;

public class MemberArrayList {

  private ArrayList<Member> arraylist;

  public MemberArrayList() {
    arraylist = new ArrayList<Member>();

  }

  public void addMember(Member mem) {
    arraylist.add(mem);
  }

  public boolean removeMember(int memberId) {
    // for (int i = 0; i < arraylist.size(); i++) {
    // Member member = arraylist.get(i);
    // int tmpId = member.getMemberId();
    // if (tmpId == memberId) {
    // arraylist.remove(i);
    // return true;
    // }

    Iterator<Member> it = arraylist.iterator();

    while (it.hasNext()) {
      Member m = it.next();
      if (memberId == m.getMemberId()) {
        arraylist.remove(m);
        return true;
      }

      System.out.println(memberId + "doesn't exist");
      return false;
    }
    System.out.println(memberId + "doesn't exits");
    return false;
  }

  public void insertMber(Member m, int position) {
    if (position < 0 || position > arraylist.size() + 1) {
      System.out.println("지정 된 자리에 추가할 수 없습니다");
      return;
    }
    arraylist.add(position - 1, m);
  }

  public void showAllMember() {
    for (Member member : arraylist) {
      System.out.println(member);
    }

    System.out.println();
  }
}

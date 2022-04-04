package com.day7_1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MemberHashMap {
  private HashMap<Integer, Member> hashmap;

  public MemberHashMap() {
    hashmap = new HashMap<Integer, Member>();

  }

  public void addMember(Member mem) {
    hashmap.put(mem.getMemberId(), mem);
  }

  public Member removeMember(int memid) {
    if (hashmap.containsKey(memid)) {
      Member m = hashmap.remove(memid);
      return m;
    }

    return null;
  }

  public void showAllMember() {
    // System.out.println(hashmap.values());
    Set<Integer> set = hashmap.keySet();
    Iterator<Integer> it = set.iterator();
    while (it.hasNext()) {
      int key = it.next();
      Member memb = hashmap.get(key);
      System.out.println(memb);

    }

  }
}

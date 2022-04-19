package com.addr.model;

import java.util.ArrayList;

public interface SAddrDAO {
	public void addrInsert(AddrDTO dto);

	public ArrayList<AddrDTO> addrList();

	public AddrDTO addrDetail(int num);

	public void addrUpdate(AddrDTO addr);

	public void addrDelete(int num);

	public ArrayList<AddrDTO> addrSearchList(String field, String word);

	public int addrCount();

	public int addrSearchCount(String field, String word);

	public ArrayList<ZipCodeDTO> addrZipRead(String dong);
}

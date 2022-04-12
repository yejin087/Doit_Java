package com.jqueryAddress;

import java.util.ArrayList;

public interface JAddressDAO {
	// �߰�
	public void insert(AddressVO avo);

	// ��ü ����
	public ArrayList<AddressVO> list();

	// �� ����
	public AddressVO findByNum(int num);

	// �����ϱ�
	public void update(AddressVO avo);

	// ����
	public void delete(int num);

	// �˻� ��ü ����
	public ArrayList<AddressVO> searchList(String field, String word);

	// �����ȣ �˻�
	public ArrayList<ZipCodeVO> getZipcode(String dong);

	// ����
	public int getCount();

	// �˻� ����
	public int getCount(String field, String word);
}

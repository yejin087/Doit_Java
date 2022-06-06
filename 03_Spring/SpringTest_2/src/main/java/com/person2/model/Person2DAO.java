package com.person2.model;

import java.util.List;

public interface Person2DAO {
	public void person_insert(PersonVO person);

	public List<PersonVO> person_list();

	public PersonVO person_view(String id);

	public void person_update(PersonVO person);

	public void person_delete(String id);

	public int person_count();
}

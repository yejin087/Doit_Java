package com.person2.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository // bean 객체가 생성된다
public class Person2DAOImpl implements Person2DAO {

	@Autowired // setter와 같은 의미
	private JdbcTemplate template;

	@Override
	public void person_insert(PersonVO person) {
		String sql = "insert into person values(?,?,?,?,?)";
		Object[] param = new Object[] { person.getId(), person.getName(), person.getPassword(), person.getGender(),
				person.getJob() };

		template.update(sql, param);

	}

	@Override
	public List<PersonVO> person_list() {
		String sql = "select * from person";
		List<PersonVO> personlist = template.query(sql, new RowMapper<PersonVO>() {

			@Override
			public PersonVO mapRow(ResultSet rs, int arg1) throws SQLException {
				PersonVO user = new PersonVO();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getString("gender"));
				user.setJob(rs.getString("job"));
				return user;
			}

		});

		return personlist;
	}

	@Override
	public PersonVO person_view(String id) {
		String sql = "select * from person where id='" + id + "'";
		PersonVO user = template.queryForObject(sql, new RowMapper<PersonVO>() {

			@Override
			public PersonVO mapRow(ResultSet rs, int arg1) throws SQLException {
				PersonVO person = new PersonVO();
				person.setId(rs.getString("id"));
				person.setName(rs.getString("name"));
				person.setPassword(rs.getString("password"));
				person.setGender(rs.getString("gender"));
				person.setJob(rs.getString("job"));
				return person;
			}

		});
		return user;
	}

	@Override
	public void person_update(PersonVO person) {
		String sql = "update person set name=?, gender =?, job =?, password=? where id=?";
		Object[] param = new Object[] { person.getName(), person.getGender(), person.getJob(), person.getPassword(),
				person.getId() };

		template.update(sql, param);

	}

	@Override
	public void person_delete(String id) {
		String sql = "delete from person where id = '" + id + "'";
		template.update(sql);

	}

	@Override
	public int person_count() {
		String sql = "select count(*) from person";
		int count = template.queryForObject(sql, Integer.class);
		return count;
	}

}

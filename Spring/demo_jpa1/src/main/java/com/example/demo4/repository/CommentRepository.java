package com.example.demo4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo4.model.Board;
import com.example.demo4.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

	// 댓글 추가JPQL
	@Modifying
	@Query(value = "insert into comment4 (content,regdate,bnum,user_id) values(?1,now(),?2,?3)", nativeQuery = true)
	public void commentInsert(String content, Long bnum, Long user_id);

	// EAGER
	@Query("select sc from Comment sc where bnum = :bnum")
	// LAZY
	// @Query("select sc from Comment sc join fetch sc.board b where b.num = :bnum")
	public List<Comment> findAllByBnum(@Param("bnum") Long bnum);

	@Query("select sc.board from Comment sc where cnum = :cnum")
	public Board findBordByCnum(@Param("cnum") Long cnum);
}

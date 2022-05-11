package com.example.demo4.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "board4")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num;
	private String title;
	private String writer;
	private String content;

	@CreationTimestamp // 날자 자동 생성 주입
	@Temporal(TemporalType.TIMESTAMP) // 날짜형
	private Date regdate;
	private Long hitcount;
	private Long replycnt;

	@OneToMany(mappedBy = "board")
	private List<Comment> comments;

	@JoinColumn(name = "user_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	@PrePersist
	public void perPersist() {
		this.hitcount = this.hitcount == null ? 0 : this.hitcount;
		this.replycnt = this.replycnt == null ? 0 : this.replycnt;
	}
}

package com.example.demo.baord.dto;

import java.sql.Date;


import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name="Board")
@Table(name="board")
@Component
@Setter
@Getter
@ToString
public class BoardDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="board_articleNo")
	@SequenceGenerator(name="board_articleNo", sequenceName="board_articleNo", allocationSize=1)
	private int articleNo;
	private String title;
	private String content;
	@Column(insertable=false, updatable=false, columnDefinition="date default sysdate")
	private Date writeDate;
	private String id;
	// 게시글을 쓸때 조회수 포함 x => insertable=false, cnt updatable은 사용)
	@Column(insertable=false, columnDefinition="number default 0")
	private int cnt;
	
}

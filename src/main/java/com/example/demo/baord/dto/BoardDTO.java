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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int articleNo;
	private String title;
	private String content;
	@Column(insertable=false, updatable=false, columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP")
	private Date writeDate;
	private String id;
	// 게시글을 쓸때 조회수 포함 x => insertable=false, cnt updatable은 사용)
	@Column(insertable=false, columnDefinition="int default 0")
	private int cnt;
	
}

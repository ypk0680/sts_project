package com.example.demo.baord.service;

import java.util.List;

import com.example.demo.baord.dto.BoardDTO;

public interface BoardService {

	List<BoardDTO> boardList();
	void insertBoard(BoardDTO dto);
	BoardDTO getBoard(int articleNo);
	void updateBoard(BoardDTO dto);
	int deleteBoard(int articleNo);	
}

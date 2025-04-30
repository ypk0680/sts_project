package com.example.demo.baord.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.baord.dao.BoardDAO;
import com.example.demo.baord.dto.BoardDTO;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDAO dao;
	
	@Override
	public List<BoardDTO> boardList() {
		// TODO Auto-generated method stub
		return dao.boardList();
	}

	@Override
	public void insertBoard(BoardDTO dto) {
		// TODO Auto-generated method stub
		dao.insertBoard(dto);
	}

	@Override
	public BoardDTO getBoard(int articleNo) {
		// TODO Auto-generated method stub
		BoardDTO dto = dao.getBoard(articleNo);
		dto.setCnt(dto.getCnt() + 1);
		dao.update(dto);
		return dto;
	}

	@Override
	public void updateBoard(BoardDTO dto) {
		// TODO Auto-generated method stub
		dao.update(dto);
	}

	@Override
	public int deleteBoard(int articleNo) {
		// TODO Auto-generated method stub
		//BoardDTO dto = dao.getBoard(articleNo);
		//dao.delete(dto);
		return dao.deleteBoard(articleNo);
	}
}

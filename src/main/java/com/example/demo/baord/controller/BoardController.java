package com.example.demo.baord.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.baord.dto.BoardDTO;

public interface BoardController {
	public String boardList(Model model);
	public String insertBoard();
	public String insertBoard(BoardDTO dto, Model model, @RequestParam("files") List<MultipartFile> files) throws IOException;
	public String getBoard(@RequestParam("articleNo") int articleNo, Model model);
	public String getBoard(BoardDTO dto, Model model);
	public String deleteBoard(@RequestParam("articleNo") int articleNo, Model model);
	
}

package com.example.demo.baord.dao;

import java.util.List;



import org.springframework.stereotype.Repository;

import com.example.demo.baord.dto.BoardDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@PersistenceContext
	private EntityManager em;
	
	public List<BoardDTO> boardList() {
		return em.createQuery("select b From Board b order by b.articleNo desc", BoardDTO.class).getResultList();
	}

	@Override
	public void insertBoard(BoardDTO dto) {
		// TODO Auto-generated method stub
		// hibernate의 JPA 방식, dto를 넣어주면 자동으로 값을 넣어주는 역할을 한다.
		em.persist(dto);
	}

	@Override
	public BoardDTO getBoard(int articleNo) {
		// TODO Auto-generated method stub
//		BoardDTO dto = (BoardDTO) em.createNativeQuery
//		 ("select * From board where article_No = :articleNo", BoardDTO.class)
//		 .setParameter("articleNo", articleNo)
//		 .getSingleResult();
		BoardDTO dto = em.createQuery
			 ("select b From Board b where b.articleNo = :articleNo", BoardDTO.class)
			 .setParameter("articleNo", articleNo)
			 .getSingleResult();		
		// hibernate의 JPA 방식
		// BoardDTO dto = em.find(BoardDTO.class, articleNo);
		return dto;
	}


	@Override
	public void update(BoardDTO dto) {
		// TODO Auto-generated method stub
		// hibernate의 JPA 방식 - update
		em.merge(dto);
	}

	@Override
	public void delete(BoardDTO dto) {
		// TODO Auto-generated method stub
		// return 값 없음
		em.remove(dto);
	}

	@Override
	public int deleteBoard(int articleNo) {
		// TODO Auto-generated method stub
		// return 값이 필요하면 createQuery를 사용해야 한다.
		// merge, remove, delete는 return 값이 없다. 
		return em.createQuery("delete from Board b where b.articleNo = :articleNo").setParameter("articleNo", articleNo).executeUpdate();
	}
}

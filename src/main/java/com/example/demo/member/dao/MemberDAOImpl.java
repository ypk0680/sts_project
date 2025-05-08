/*
 * package com.example.demo.member.dao;
 * 
 * import java.util.List;
 * 
 * import org.springframework.stereotype.Repository;
 * 
 * import com.example.demo.baord.dto.BoardDTO; import
 * com.example.demo.member.dto.MemberDTO;
 * 
 * import jakarta.persistence.EntityManager; import
 * jakarta.persistence.PersistenceContext;
 * 
 * @Repository public class MemberDAOImpl implements MemberDAO{
 * 
 * @PersistenceContext private EntityManager em;
 * 
 * @Override public void insertMember(MemberDTO dto) { // TODO Auto-generated
 * method stub em.persist(dto); }
 * 
 * @Override public List<MemberDTO> memberList() { // TODO Auto-generated method
 * stub return em.createQuery("select m From Member m ",
 * MemberDTO.class).getResultList();
 * 
 * }
 * 
 * @Override public MemberDTO detailMember(String id) { // TODO Auto-generated
 * method stub MemberDTO dto = em.find(MemberDTO.class, id); return dto; }
 * 
 * }
 */
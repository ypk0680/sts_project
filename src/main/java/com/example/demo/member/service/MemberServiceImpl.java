package com.example.demo.member.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.repository.MemberRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberRepository repository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public List<MemberDTO> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void save(MemberDTO dto) {
		// TODO Auto-generated method stub
		String encodedPwd = passwordEncoder.encode(dto.getPwd());
		dto.setPwd(encodedPwd);
		repository.save(dto);
	}

	@Override
	public MemberDTO findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("회원정보가 없습니다."));
	}

	@Override
	public int merge(MemberDTO dto) {
		// TODO Auto-generated method stub
		int result = repository.updateMember(dto.getId(), dto.getPwd(), dto.getName(), dto.getEmail());
		return result;
	}

	@Override
	public int remove(String id) {
		// TODO Auto-generated method stub
		int result = repository.deleteMember(id);
		return result;
	}
 
	@Override
	public boolean login(String id, String pwd) {
		// TODO Auto-generated method stub
		Optional<MemberDTO> memberOpt = repository.findById(id);
	
		if(memberOpt.isPresent()) {   // isPresent : 값이 있는지, 없는지~
			MemberDTO member = memberOpt.get();
			String savePwd = member.getPwd();
			if(passwordEncoder.matches(pwd, savePwd)) { // pwd 평문 , savePwd 암호화된 암호
				return true;
			}
		}
		return false;
	}

}




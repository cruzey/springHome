package com.edu.member.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.member.dao.MemberDao;
import com.edu.member.model.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	public MemberDao memberDao;
	
	@Override
	public List<MemberVo> memberSelectList(String searchOption, String keyword, int start, int end){
		
		return memberDao.memberSelectList(searchOption, keyword, start, end);
	}

	@Override
	public MemberVo memberExist(String email, String password) {
		// TODO Auto-generated method stub
		return memberDao.memberExist(email, password);
	}

	@Override
	public int memberInsertOne(MemberVo memberVo) {
		// TODO Auto-generated method stub
		
		return memberDao.memberInsertOne(memberVo);
	}
	
	@Override
	public int memberUpdateOne(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return memberDao.memberUpdateOne(memberVo);
	}

	@Override
	public MemberVo memberSelectOne(int no) {
		// TODO Auto-generated method stub
		return memberDao.memberSelectOne(no);
	}
	
	@Override
	public void memberDeleteOne(int no) {
		// TODO Auto-generated method stub
		memberDao.memberDeleteOne(no);
	}
	
	@Override
	public int memberSelectTotalCount() {
		// TODO Auto-generated method stub
		return memberDao.memberSelectTotalCount();
	}
}

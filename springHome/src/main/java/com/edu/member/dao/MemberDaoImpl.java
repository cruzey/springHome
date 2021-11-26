package com.edu.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.member.model.MemberVo;

@Repository
public class MemberDaoImpl implements MemberDao {
		
	@Autowired
	SqlSessionTemplate sqlSession;
	
	String nameSpace = "com.edu.member.";
		
	@Override
	public List<MemberVo> memberSelectList(String searchOption, String keyword, int start, int end){
		
		Map<String, Object> map = new HashMap<>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);
		
		return sqlSession.selectList(nameSpace + "memberSelectList", map);
	}
	
	@Override
	public MemberVo memberExist(String email, String password) {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("email",email);
		paramMap.put("password",password);
		
		return sqlSession.selectOne(nameSpace + "memberExist", paramMap);
	}

	@Override
	public int memberInsertOne(MemberVo memberVo) {
		// TODO Auto-generated method stub
		
		return sqlSession.insert(nameSpace + "memberInsertOne", memberVo);
	}
	
	@Override
	public int memberUpdateOne(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return sqlSession.update(nameSpace + "memberUpdateOne", memberVo);
	}
	
	@Override
	public MemberVo memberSelectOne(int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + "memberSelectOne", no);
	}
	
	@Override
	public void memberDeleteOne(int no) {
		// TODO Auto-generated method stub
		sqlSession.delete(nameSpace + "memberDeleteOne", no);
	}
	
	@Override
	public int memberSelectTotalCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + "memberSelectTotalCount");
	}
}

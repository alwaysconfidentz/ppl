package com.food.k1.fmember;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FmemberServiceImpl implements FmemberService {

	@Autowired
	FmemberDao dao;

	@Override
	public void insert(com.food.k1.fmember.FmemberVo vo) {
		dao.insert(vo);

	}

	@Override
	public List<com.food.k1.fmember.FmemberVo> getfmemberList(com.food.k1.fmember.FmemberVo vo) {
		// TODO Auto-generated method stub
		return dao.getfmemberList(vo);
	}

	@Override
	public FmemberVo fmemberck(FmemberVo vo) {
		// TODO Auto-generated method stub
		return dao.fmemberck(vo);
	}

	@Override
	public void update(FmemberVo vo) {
		
	
		
		dao.update(vo);
	}

	@Override
	public void delete(FmemberVo vo) {
		dao.delete(vo);
	}

	@Override
	public FmemberVo getfmember(FmemberVo vo) {
		// TODO Auto-generated method stub
		return dao.getfmember(vo);
	}

	@Override
	public int totalcount(FmemberVo vo) {
		
		return dao.totalcount(vo);
	}

	@Override
	public FmemberVo login(FmemberVo vo) {
		
		
		return dao.login(vo);
	}

}

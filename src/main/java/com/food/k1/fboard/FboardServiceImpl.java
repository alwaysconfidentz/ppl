package com.food.k1.fboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FboardServiceImpl implements FboardService {

	@Autowired
	FboardDao dao;
	
	
	@Override
	public void finsert(FboardVo vo) {
		dao.finsert(vo);
		
	}

	@Override
	public void fupdate(FboardVo vo) {
		dao.fupdate(vo);
		
	}

	@Override
	public void fdelete(FboardVo vo) {
		dao.fdelete(vo);
		
	}

	@Override
	public List<FboardVo> getFoodList(FboardVo vo) {
		return dao.getFoodList(vo);
	}

	@Override
	public FboardVo getFood(FboardVo vo) {
		// TODO Auto-generated method stub
		return dao.getFood(vo);
	}

	@Override
	public int fbcount(FboardVo vo) {
		// TODO Auto-generated method stub
		return dao.fbcount(vo);
	}

	@Override
	public void saveinsert(FboardVo vo) {
		dao.saveinsert(vo);
		
	}

	@Override
	public List<FboardVo> savelist(FboardVo vo) {
		// TODO Auto-generated method stub
		return dao.savelist(vo);
	}

	



}

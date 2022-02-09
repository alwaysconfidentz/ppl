package com.food.k1.fboard;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class FboardDaoImpl implements FboardDao {

	
	@Autowired
	SqlSessionTemplate mybatis;
	
	
	@Override
	public void finsert(FboardVo vo) {
		mybatis.insert("fboard-mapping.fboard_insert",vo);
		
	}

	@Override
	public void fupdate(FboardVo vo) {
		mybatis.update("fboard-mapping.fupdate",vo);
		
	}

	@Override
	public void fdelete(FboardVo vo) {
		mybatis.delete("fboard-mapping.fdelete",vo);
		
	}

	@Override
	public List<FboardVo> getFoodList(FboardVo vo) {
		
		return mybatis.selectList("fboard-mapping.getfboardList",vo);
	}

	@Override
	public FboardVo getFood(FboardVo vo) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("fboard-mapping.getfboard",vo);
	}

	@Override
	public int fbcount(FboardVo vo) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("fboard-mapping.fbcount",vo);
	}

	@Override
	public void saveinsert(FboardVo vo) {
		mybatis.insert("fboard-mapping.saveinsert",vo);
		
	}

	@Override
	public List<FboardVo> savelist(FboardVo vo) {
		// TODO Auto-generated method stub
		return mybatis.selectList("fboard-mapping.saveList",vo);
	}

	


}

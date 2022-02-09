package com.food.k1.fmember;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FmemberDaoImpl implements FmemberDao {

	@Autowired
	SqlSessionTemplate mybatis1;

	@Override
	public void insert(FmemberVo vo) {
		mybatis1.insert("fmember-mapping.insert_fmember", vo);
	}

	@Override
	public List<FmemberVo> getfmemberList(FmemberVo vo) {
		return mybatis1.selectList("fmember-mapping.select_fmember", vo);
	}

	@Override
	public FmemberVo fmemberck(FmemberVo vo) {
		// TODO Auto-generated method stub
		return mybatis1.selectOne("fmember-mapping.fck_fmember", vo);
	}

	@Override
	public void update(FmemberVo vo) {
		mybatis1.update("fmember-mapping.fmember_update", vo);
	}

	@Override
	public void delete(FmemberVo vo) {
		mybatis1.delete("fmember-mapping.delete_fmember", vo);
	}

	@Override
	public FmemberVo getfmember(FmemberVo vo) {
		// TODO Auto-generated method stub
		return mybatis1.selectOne("fmember-mapping.content_fmember1", vo);
	}

	@Override
	public int totalcount(FmemberVo vo) {
	
		return mybatis1.selectOne("fmember-mapping.fmember_tc",vo);
	}

	@Override
	public FmemberVo login(FmemberVo vo) {
		// TODO Auto-generated method stub
		return mybatis1.selectOne("fmember-mapping.login_fmember",vo);
	}

}

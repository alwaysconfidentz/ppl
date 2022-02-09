package com.food.k1.fmember;

import java.util.List;

public interface FmemberDao {

	public void insert(FmemberVo vo);

	public List<FmemberVo> getfmemberList(FmemberVo vo);

	public FmemberVo fmemberck(FmemberVo vo);

	public void update(FmemberVo vo);

	public void delete(FmemberVo vo);

	public FmemberVo getfmember(FmemberVo vo);
	
	public int totalcount(FmemberVo vo);
	
	public FmemberVo login(FmemberVo vo);
	

	
	
}

package com.food.k1.fboard;

import java.util.List;

public interface FboardService {

	public void finsert(FboardVo vo);
	public void fupdate(FboardVo vo);
	public void fdelete(FboardVo vo);
	public List<FboardVo> getFoodList(FboardVo vo);
	public FboardVo getFood(FboardVo vo);
	public int fbcount(FboardVo vo);
	
	public void saveinsert(FboardVo vo);
	
	public List<FboardVo> savelist(FboardVo vo);

	
	
}

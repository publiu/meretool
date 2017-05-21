package com.mereking.meretool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mereking.meretool.dto.QuerySkillLinkResultDTO;
import com.mereking.meretool.dto.QuerySkillLinkResultListDTO;
import com.mereking.meretool.entity.Skill;
import com.mereking.meretool.entity.Stock;

public interface StockDao {

	Skill getById(Integer id);
	
	/**
	 * 根据gid查询
	 * @param gid
	 * @return
	 */
	List<Stock> queryStocksByGid(String gid);
	
	List<Stock> queryStocks();

	Integer insertStock(Stock stock);
}

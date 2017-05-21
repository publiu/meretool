package com.mereking.meretool.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mereking.meretool.dto.InsertSkillDTO;
import com.mereking.meretool.dto.QueryAllSkillDTO;
import com.mereking.meretool.dto.QuerySkillLinkDTO;
import com.mereking.meretool.dto.QuerySkillLinkResultDTO;
import com.mereking.meretool.dto.UpdateSkillDTO;
import com.mereking.meretool.entity.Skill;
import com.mereking.meretool.entity.Stock;
/**
 * 股票服务
 * @author mereKing
 *
 */
public interface StockService {
	
	Stock getById(Integer id);
	
	/**
	 * 根据gid查询
	 * @param gid
	 * @return
	 */
	List<Stock> queryStocksByGid(String gid);
	
	List<Stock> queryStocks();
	
	/**
	 * 拉取
	 * @return
	 */
	void pullStocks();

}

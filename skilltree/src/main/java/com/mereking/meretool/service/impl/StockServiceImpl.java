package com.mereking.meretool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mereking.meretool.dao.StockDao;
import com.mereking.meretool.entity.Stock;
import com.mereking.meretool.service.StockService;

/**
 * 股票服务
 * @author mereKing
 *
 */
@Service
public class StockServiceImpl implements StockService {
	@Autowired
	private StockDao stockDao;

	@Override
	public Stock getById(Integer id) {
		
		return null;
	}

	@Override
	public List<Stock> queryStocksByGid(String gid) {
		
		return null;
	}

	@Override
	public List<Stock> queryStocks() {
		
		return null;
	}

	@Override
	public void pullStocks() {
		/*List<Stock> szStocks = StockPullImpl.getAllStock("sz",stockDao);
		System.out.println("深圳总共股票数"+szStocks.size());*/
		List<Stock> shStocks = StockPullImpl.getAllStock("sh",stockDao);
		System.out.println("上海总共股票数"+shStocks.size());
	}

	
	
	
	

}

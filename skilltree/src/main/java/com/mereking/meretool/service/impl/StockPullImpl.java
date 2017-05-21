package com.mereking.meretool.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.mereking.meretool.dao.StockDao;
import com.mereking.meretool.entity.Stock;
import com.mereking.meretool.util.HttpRequest;

/**
 * 拉取股票
 * 
 * 股票类型：http://www.sinaimg.cn/cj/financewidget/js/SuggestServer_3_0_11.js
 */
public class StockPullImpl {
	
	protected static final Logger logger = LoggerFactory.getLogger(StockPullImpl.class);
	
	
	public static List<Stock> getAllStock(String szOrsh, StockDao stockDao) {
		String url = "http://suggest3.sinajs.cn/suggest/type=11,12,13,14,15&name=suggestdata_suggestdata_1494719004913&key=";
		
		List<Stock> stocks = new ArrayList<>();
		/*String res = HttpRequest.sendGet(url+szOrsh+"0000", "", "GBK");
		List<Stock> stocksTemp = parseResStr(res, url);
		stocks.addAll(stocksTemp);
		return stocks;*/
		
		
		String res = "";
		for (int t=0; t<100; t++) {
			// 顶层no
			String tno = getGid(String.valueOf(t));
			// 校验该层是否有数据
			res = HttpRequest.sendGet(url+szOrsh+tno, "", "GBK");
			List<Stock> tStocks = parseResStr(res, url);
			
			if (tStocks.size() > 0) {
				for (int h=0; h<100; h++) {
					// 高位
					String hno = getGid(String.valueOf(h));
					// 校验该层是否有数据
					res = HttpRequest.sendGet(url+szOrsh+tno+hno, "", "GBK");
					List<Stock> hStocks = parseResStr(res, url);
					
					if (hStocks.size() > 0) {
						for (int l=0; l<10; l++) {
							// 低位,最后一位1~9
							String lno = String.valueOf(l);
							res = HttpRequest.sendGet(url+szOrsh+tno+hno+lno, "", "GBK");
							List<Stock> stocksTemp = parseResStr(res, url);
							// 插入股票
							for (Stock stock : stocksTemp) {
								List<Stock> gidStocks = stockDao.queryStocksByGid(stock.getGid());
								if (!(gidStocks != null && gidStocks.size() > 0)) {
									stockDao.insertStock(stock);
								}
							}
							stocks.addAll(stocksTemp);
						}
					}
				}
			}
		}
		return stocks;
	}
	
	/**
	 * 字符串补位
	 * @param no
	 * @return
	 */
	private static String getGid(String no) {
		if (StringUtils.isEmpty(no)) {
			no = "";
		}
		if (no.length() < 2) {
			Integer length = 2-no.length();
			for (int i=0; i<length; i++) {
				no = "0"+no;
			}
		}
		return no;
	}

	
	/**
	 * 解析股票数据
	 * @param res 请求结果
	 * @param url 地址
	 * @return
	 */
	private static List<Stock> parseResStr(String res, String url) {
		List<Stock> stocks = new ArrayList<Stock>();
		if (res != null && res.contains("var suggestdata")) {
			String resL[] = res.split("\"");
			if (resL.length == 3) {
				// 获取引号内部数据
				String stocksStr = resL[1];
				if (!"".equals(stocksStr)) {
					
					String stockStrs[] = stocksStr.split(";");
					for (int i=0; i<stockStrs.length; i++) {
						
						String stockInfoStr = stockStrs[i];
						String stockInfos[] = stockInfoStr.split(",");
						if (stockInfos.length == 6) {
							Stock stock = new Stock();
							stock.setGid(stockInfos[0]);
							stock.setGidShort(stockInfos[2]);
							stock.setName(stockInfos[4]);
							stock.setNameShort(stockInfos[5]);
							stock.setType(Integer.parseInt(stockInfos[1]));
							stocks.add(stock);
							logger.info("股票代码："+stockInfos[0]+" 股票类型："+stockInfos[1]+" 股票简代码："+stockInfos[2]+" 股票名称："+stockInfos[4]+" 股票英文简称："+stockInfos[5]);
						} else {
							logger.info("股票格式错误：url"+url+";stockInfos="+stockInfos);
						}
					}
					
				}
			} else {
				logger.info("股票数据个数错误：url="+url);
			}
		} else {
			logger.info("获取出错：url"+url);
		}
		return stocks;
	}

}

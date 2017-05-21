package com.mereking.meretool.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mereking.meretool.service.StockService;
/**
 * 股票拉取
 * 
 * @author http://biz.finance.sina.com.cn/suggest/lookup_n.php?q=&country=stock
 *
 */
@Controller
@RequestMapping("/stock")
public class StockPull {
	
	@Autowired
	private StockService stockService;
	
	
	@RequestMapping("/stockPull")
	@ResponseBody
	public Map<String, Object> stockPull(String text, Model model, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		stockService.pullStocks();
		result.put("success", "success");
		
		return result;
	}

}

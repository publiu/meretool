package com.mereking.meretool.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.map.HashedMap;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mereking.meretool.dto.InsertSkillDTO;
import com.mereking.meretool.service.SkillService;
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
	
	@Autowired
	private SkillService skillService;
	@RequestMapping("/stockPull")
	@ResponseBody
	public Map<String, Object> stockPull(String text, Model model, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		stockService.pullStocks();
		result.put("success", "success");
		
		return result;
	}
	
	@RequestMapping("/insertAlertSkillAjax")
	@ResponseBody
	public Map<String, Object> insertAlertSkillAjax(String skillName, String skillDetail, Integer userId, HttpServletRequest request) {
		InsertSkillDTO insertSkillDTO = new InsertSkillDTO(1, skillName, skillDetail, userId);
		skillService.insertSkill(insertSkillDTO);
		Map<String, Object> result = new HashedMap();
		result.put("errorNo", 0);
		result.put("errorInfo", "");
		return result;
	}

}

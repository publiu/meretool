package com.mereking.meretool.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 分词器工具
 * 
 * @author https://github.com/ysc/word
 *
 */
@Controller
@RequestMapping("/word")
public class WordPPL {
	
	@RequestMapping("/segStr")
	@ResponseBody
	public Map<String, Object> segStr(String text, Model model, HttpServletRequest request) {
		// 执行分词
		List<Word> words = WordSegmenter.seg(text);
		
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("words", words);
		
		return result;
	}

}

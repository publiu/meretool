package com.mereking.meretool.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mereking.meretool.dto.InsertSkillDTO;
import com.mereking.meretool.dto.QuerySkillLinkDTO;
import com.mereking.meretool.dto.QuerySkillLinkResultDTO;
import com.mereking.meretool.dto.SkillAjaxLinkVO;
import com.mereking.meretool.dto.SkillAjaxNodeVO;
import com.mereking.meretool.entity.Skill;
import com.mereking.meretool.service.SkillService;

@Controller
@RequestMapping("/skill")
public class SkillAction {
	@Autowired
	private SkillService skillService;
	
	@RequestMapping("/queryAllSkill")
	public String queryAllSkill(Model model, HttpServletRequest request) {
		List<Skill> skills = skillService.queryALLSkill();
		model.addAttribute("skills", skills);
		return "skill/skill_list";
	}
	
	@RequestMapping("/queryAllSkillAjax")
	@ResponseBody
	public Map<String, Object> queryAllSkillAjax() {
		List<QuerySkillLinkResultDTO> querySkillLinkResultDTOs = skillService.querySkillLink(new QuerySkillLinkDTO());
		// 定义节点
		List<SkillAjaxNodeVO> nodes = new ArrayList<SkillAjaxNodeVO>();
		// 定义关联关系
		List<SkillAjaxLinkVO> links = new ArrayList<SkillAjaxLinkVO>();
		
		// 增加根节点
		SkillAjaxNodeVO root = new SkillAjaxNodeVO(1, "根节点", 0);
		nodes.add(root);
		// 增加节点及关联关系
		for (QuerySkillLinkResultDTO querySkillLinkResultDTO : querySkillLinkResultDTOs) {
			SkillAjaxNodeVO skillAjaxNodeVO = new SkillAjaxNodeVO(querySkillLinkResultDTO);
			nodes.add(skillAjaxNodeVO);
			SkillAjaxLinkVO skillAjaxLinkVO = new SkillAjaxLinkVO(querySkillLinkResultDTO);
			links.add(skillAjaxLinkVO);
		}
		
		Map<String, Object> result = new HashedMap();
		result.put("nodes", nodes);
		result.put("links", links);
		return result;
	}
	
	@RequestMapping("/getSkillBySkillID")
	public String getSkillBySkillID(Integer skillID, Model model) {
		Skill skill = skillService.getBySkillID(skillID);
		model.addAttribute("skill", skill);
		return "skill/skill_view";
	}
	
	@RequestMapping("/insertSkillPage")
	public String gotoInsertSkill(Integer parentSkillID, Model model, HttpServletRequest request) {
		Skill skill = skillService.getBySkillID(parentSkillID);
		model.addAttribute("skill", skill);
		return "skill/skill_insert";
	}
	
	@RequestMapping("/insertSkill")
	public String insertSkill(InsertSkillDTO insertSkillDTO) {
		skillService.insertSkill(insertSkillDTO);
		return "redirect:queryAllSkill";
	}
	
	@RequestMapping("/deleteSkill")
	public String deleteSkill(Integer skillID) {
		skillService.deleteSkill(skillID);
		return "redirect:queryAllSkill";
	}
	
	@RequestMapping("/updateIncreaseSkillLevel")
	public String updateIncreaseSkillLevel(Integer skillID) {
		skillService.updateIncreaseSkillLevel(skillID);
		return "redirect:queryAllSkill";
	}
	@RequestMapping("/updateDecreaseSkillLevel")
	public String updateDecreaseSkillLevel(Integer skillID) {
		skillService.updateDecreaseSkillLevel(skillID);
		return "redirect:queryAllSkill";
	}

}

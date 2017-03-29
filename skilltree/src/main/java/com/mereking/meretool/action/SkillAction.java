package com.mereking.meretool.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

}

package com.mereking.meretool.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeAction {
	@RequestMapping("/")
	public String welcome() {
		return "redirect:/skill/queryAllSkill";
	}

}

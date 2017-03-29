package com.mereking.meretool.action;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mereking.meretool.common.BaseTest;

public class SkillActionTest extends BaseTest{

	@Autowired
	private SkillAction skillAction;
	@Test
	public void queryAllSkill() throws Exception{
		// 建立mock
		MockMvc  mockMvc = MockMvcBuilders.standaloneSetup(skillAction).build();
		// 测试返回路径
		mockMvc.perform(MockMvcRequestBuilders.post("/skill/queryAllSkill"))
			.andExpect(MockMvcResultMatchers.view().name("skill/skill_list"))
			;
		
	}
}

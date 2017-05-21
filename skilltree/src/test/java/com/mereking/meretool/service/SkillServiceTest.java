package com.mereking.meretool.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mereking.meretool.common.BaseTest;
import com.mereking.meretool.entity.Skill;

public class SkillServiceTest extends BaseTest {
	@Autowired
	private SkillService skillService;
	@Test
	public void queryAllSkill() {
		//List<Skill> skills = skillService.queryALLSkill();
		//Assert.assertEquals("技能树", skills.get(0).getSkillName());
	}

}

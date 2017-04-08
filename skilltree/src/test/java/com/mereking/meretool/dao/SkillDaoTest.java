package com.mereking.meretool.dao;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.mereking.meretool.common.BaseTest;
import com.mereking.meretool.entity.Skill;

public class SkillDaoTest extends BaseTest {
	@Autowired
	private SkillDao skillDao;
	@Test
	public void getSkill() {
		Integer skillID = 1;
		Skill skill = skillDao.getById(skillID);
		Assert.assertEquals("技能树", skill.getSkillName());
	}
	@Test
	public void queryAllSkill() {
		List<Skill> skills = skillDao.queryAllSkill();
		Assert.assertEquals("技能树", skills.get(0).getSkillName());
	}
	
	@Test
	@Transactional
	public void insertSkillAndUpdate() {
		Skill skill = new Skill("测试技能插入", "测试技能插入-详情", new Date());
		// 获取父技能
		Skill parentSkill = skillDao.getById(1);
		Integer rightSkillNo = parentSkill.getRightSkillNo();
		// 更新关联关系
		Integer no = skillDao.updateSkillByInsert(parentSkill.getRightSkillNo());
		Assert.assertEquals(true, no>=0);
		
		// 插入新技能
		Integer res = skillDao.insertSkill(skill);
		Assert.assertEquals(true, res>0);
		// 初始化关联关系
		skill.initSkillRelation(rightSkillNo, rightSkillNo+1, 0, parentSkill.getLayer()+1);
		// 插入关联关系
		Integer resi = skillDao.insertSkillRelation(skill);
		Assert.assertEquals(true, resi>0);
	}
	
	@Test
	@Transactional
	public void deleteSkillAndUpdate() {
		Skill skill = skillDao.getById(2);
		Integer leftSkillNo = skill.getLeftSkillNo();
		Integer rightSkillNo = skill.getRightSkillNo();
		// 删除一个技能
		Integer res2 = skillDao.deleteSkillAndRelation(leftSkillNo, rightSkillNo);
		Assert.assertEquals(true, res2>=0);
		// 更新技能关联
		Integer res = skillDao.updateSkillByDelete(leftSkillNo, rightSkillNo);
		Assert.assertEquals(true, res>=0);
		
	}
}

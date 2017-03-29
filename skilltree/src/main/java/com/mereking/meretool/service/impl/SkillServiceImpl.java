package com.mereking.meretool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mereking.meretool.dao.SkillDao;
import com.mereking.meretool.entity.Skill;
import com.mereking.meretool.service.SkillService;

/**
 * 技能服务
 * @author mereKing
 *
 */
@Service
public class SkillServiceImpl implements SkillService {
	@Autowired
	private SkillDao skillDao;

	public Skill getBySkillID(Integer skillID) {
		return skillDao.getById(skillID);
	}

	public List<Skill> queryALLSkill() {
		return skillDao.queryAllSkill();
	}

	
	
	

}

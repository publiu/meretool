package com.mereking.meretool.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mereking.meretool.dao.SkillDao;
import com.mereking.meretool.dto.InsertSkillDTO;
import com.mereking.meretool.dto.QueryAllSkillDTO;
import com.mereking.meretool.dto.QuerySkillLinkDTO;
import com.mereking.meretool.dto.QuerySkillLinkResultDTO;
import com.mereking.meretool.dto.UpdateSkillDTO;
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

	public List<Skill> queryALLSkill(QueryAllSkillDTO queryAllSkillDTO) {
		Skill skill = skillDao.getById(queryAllSkillDTO.getSkillID());
		return skillDao.queryAllSkill(skill.getLeftSkillNo(), skill.getRightSkillNo(), skill.getLayer() + queryAllSkillDTO.getLayerNum());
	}

	@Transactional
	@Override
	public void insertSkill(InsertSkillDTO insertSkillDTO) {
		Skill skill = new Skill(insertSkillDTO.getSkillName(), insertSkillDTO.getSkillDetail(), new Date());
		Skill parentSkill = skillDao.getById(insertSkillDTO.getParentSkillID());
		Integer rightSkillNo = parentSkill.getRightSkillNo();
		// 更新关联关系
		skillDao.updateSkillByInsert(rightSkillNo);
		// 插入操作
		skillDao.insertSkill(skill);
		
		// 初始化关联关系
		skill.initSkillRelation(rightSkillNo, rightSkillNo+1, 0, parentSkill.getLayer() + 1);
		// 插入关联关系
		skillDao.insertSkillRelation(skill);
	}

	@Transactional
	@Override
	public void deleteSkill(Integer skillID) {
		Skill skill = skillDao.getById(skillID);
		Integer leftSkillNo = skill.getLeftSkillNo();
		Integer rightSkillNo = skill.getRightSkillNo();
		// 删除一个技能
		skillDao.deleteSkillAndRelation(leftSkillNo, rightSkillNo);
		// 更新技能关联
		skillDao.updateSkillByDelete(leftSkillNo, rightSkillNo);
	}

	@Override
	public void updateIncreaseSkillLevel(Integer skillID) {
		skillDao.updateIncreaseSkillLevel(skillID);
	}

	@Override
	public void updateDecreaseSkillLevel(Integer skillID) {
		skillDao.updateDecreaseSkillLevel(skillID);
	}

	@Override
	public List<QuerySkillLinkResultDTO> querySkillLink(QuerySkillLinkDTO querySkillLinkDTO) {
		List<QuerySkillLinkResultDTO> querySkillLinkResultDTOs = skillDao.querySkillLink().getQuerySkillLinkResultDTOs();
		return querySkillLinkResultDTOs;
	}

	@Override
	public void updateSkill(UpdateSkillDTO updateSkillDTO) {
		Skill skill = skillDao.getById(updateSkillDTO.getSkillID());
		skill.setSkillName(updateSkillDTO.getSkillName());
		skill.setSkillDetail(updateSkillDTO.getSkillDetail());
		skill.setSkillModified(new Date());
		skillDao.updateSkill(skill);
	}

	@Override
	public List<Skill> querySkillsByLayer(Integer layer) {
		return skillDao.querySkillsByLayer(layer);
	}

	
	
	

}

package com.mereking.meretool.service;

import java.util.List;

import com.mereking.meretool.dto.InsertSkillDTO;
import com.mereking.meretool.dto.QueryAllSkillDTO;
import com.mereking.meretool.dto.QuerySkillLinkDTO;
import com.mereking.meretool.dto.QuerySkillLinkResultDTO;
import com.mereking.meretool.dto.UpdateSkillDTO;
import com.mereking.meretool.entity.Skill;
/**
 * 技能服务
 * @author mereKing
 *
 */
public interface SkillService {
	
	/**
	 * 查询单个技能
	 * @param skillID
	 * @return
	 */
	public Skill getBySkillID(Integer skillID);
	/**
	 * 查询技能列表
	 * @return
	 */
	public List<Skill> queryALLSkill(QueryAllSkillDTO queryAllSkillDTO);
	
	/**
	 * 查询当前层次的所有技能
	 * @param layer
	 * @return
	 */
	public List<Skill> querySkillsByLayer(Integer layer);
	
	/**
	 * 查询技能关联关系
	 * @return
	 */
	public List<QuerySkillLinkResultDTO> querySkillLink(QuerySkillLinkDTO querySkillLinkDTO);
	
	
	/**
	 * 插入一个技能
	 * @param insertSkillDTO
	 */
	public void insertSkill(InsertSkillDTO insertSkillDTO);

	/**
	 * 删除一个技能
	 * @param skillID
	 */
	public void deleteSkill(Integer skillID);
	
	/**
	 * 更新一个技能
	 * @param updateSkillDTO
	 */
	public void updateSkill(UpdateSkillDTO updateSkillDTO);
	
	/**
	 * 增加技能等级
	 * @param skillID
	 */
	public void updateIncreaseSkillLevel(Integer skillID);
	
	/**
	 * 减少及技能等级
	 * @param skillID
	 */
	public void updateDecreaseSkillLevel(Integer skillID);

}

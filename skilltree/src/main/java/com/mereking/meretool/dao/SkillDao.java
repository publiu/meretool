package com.mereking.meretool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mereking.meretool.dto.QuerySkillLinkResultDTO;
import com.mereking.meretool.dto.QuerySkillLinkResultListDTO;
import com.mereking.meretool.entity.Skill;

public interface SkillDao {
	/**
	 * 查询技能
	 * @param skillId 技能ID
	 * @return
	 */
	Skill getById(Integer skillID);
	
	/**
	 * 查询所有技能
	 * @return
	 */
	List<Skill> queryAllSkill();
	
	/**
	 * 查询技能关联关系
	 * @return
	 */
	QuerySkillLinkResultListDTO querySkillLink();
	
	/**
	 * 插入技能
	 * @param skill
	 * @return
	 */
	Integer insertSkill(Skill skill);
	
	/**
	 * 插入技能关联关系
	 * @param skill
	 * @return
	 */
	Integer insertSkillRelation(Skill skill);
	
	/**
	 * 更新技能，插入后执行
	 * @param rightSkillNo
	 * @return
	 */
	Integer updateSkillByInsert(Integer rightSkillNo);
	
	/**
	 * 更新技能节点
	 * @param leftSkillNo 技能左值
	 * @param rightSkillNo 技能右值
	 * @return
	 */
	Integer updateSkillByDelete(@Param("leftSkillNo") Integer leftSkillNo, @Param("rightSkillNo") Integer rightSkillNo);
	
	/**
	 * 删除一个技能
	 * @param leftSkillNo 技能左值
	 * @param rightSkillNo 技能右值
	 * @return
	 */
	Integer deleteSkillAndRelation(@Param("leftSkillNo") Integer leftSkillNo, @Param("rightSkillNo") Integer rightSkillNo);
	
	/**
	 * 增加技能等级
	 * @param skillID
	 * @return
	 */
	Integer updateIncreaseSkillLevel(Integer skillID);
	/**
	 * 减少技能等级
	 * @param skillID
	 * @return
	 */
	Integer updateDecreaseSkillLevel(Integer skillID);

}

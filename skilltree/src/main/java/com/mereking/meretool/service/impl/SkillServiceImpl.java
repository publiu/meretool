package com.mereking.meretool.service.impl;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.mereking.meretool.dao.SkillDao;
import com.mereking.meretool.dto.InsertSkillDTO;
import com.mereking.meretool.dto.QueryAllSkillDTO;
import com.mereking.meretool.dto.QuerySkillLinkDTO;
import com.mereking.meretool.dto.QuerySkillLinkResultDTO;
import com.mereking.meretool.dto.UpdateSkillDTO;
import com.mereking.meretool.entity.Skill;
import com.mereking.meretool.service.SkillService;
import com.mereking.meretool.util.FileUtils;

/**
 * 技能服务
 * @author mereKing
 *
 */
@Service
public class SkillServiceImpl implements SkillService {
	
	private static final Logger logger = LoggerFactory.getLogger(SkillServiceImpl.class);
	
	@Autowired
	private SkillDao skillDao;

	public Skill getBySkillID(Integer skillID) {
		return skillDao.getById(skillID);
	}

	public List<Skill> queryALLSkill(QueryAllSkillDTO queryAllSkillDTO) {
		Skill skill = skillDao.getById(queryAllSkillDTO.getSkillID());
		return skillDao.queryAllSkill(skill.getLeftSkillNo(), skill.getRightSkillNo(), skill.getLayer() + queryAllSkillDTO.getLayerNum(), queryAllSkillDTO.getUserId());
	}

	@Transactional
	@Override
	public Skill insertSkill(InsertSkillDTO insertSkillDTO) {
		Skill skill = new Skill(insertSkillDTO.getSkillName(), insertSkillDTO.getSkillDetail(), new Date(), insertSkillDTO.getUserId());
		if (insertSkillDTO.getCreateTime() != null) {
			skill.setSkillCreate(insertSkillDTO.getCreateTime());
		}
		Skill parentSkill = skillDao.getById(insertSkillDTO.getParentSkillID());
		skill = insertSkill(skill, parentSkill);
		
		return skill;
	}
	
	/**
	 * 插入技能
	 * @param skill
	 * @param parentSkill
	 * @return
	 */
	private Skill insertSkill(Skill skill, Skill parentSkill) {
		Integer rightSkillNo = parentSkill.getRightSkillNo();
		// 更新关联关系
		skillDao.updateSkillByInsert(rightSkillNo);
		// 插入操作
		skillDao.insertSkill(skill);
		
		// 初始化关联关系
		skill.initSkillRelation(rightSkillNo, rightSkillNo+1, 0, parentSkill.getLayer() + 1);
		// 插入关联关系
		skillDao.insertSkillRelation(skill);
		
		return skill;
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
		List<QuerySkillLinkResultDTO> querySkillLinkResultDTOs = skillDao.querySkillLink(querySkillLinkDTO.getUserId()).getQuerySkillLinkResultDTOs();
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
	public List<Skill> querySkillsByLayer(Integer layer, Integer userId) {
		return skillDao.querySkillsByLayer(layer, userId);
	}


	
	@Transactional
	@Override
	public Map<String, Object> importXmindFile(Integer userId, MultipartFile file, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 获取根节点
		Element root = getRootElementByXmlFile(file, request);
		if (root != null) {
			// 读取根节点名称
			String rootName = root.attributeValue("TEXT");
			// 查询是否存在该节点
			List<Skill> skillsSameName = skillDao.querySkillBySkillName(rootName, userId);
			if (skillsSameName.size() == 1) {
				Skill skill = skillsSameName.get(0);
				// 删除原根节点数据
				skillDao.deleteSkillAndRelation(skill.getLeftSkillNo() + 1, skill.getRightSkillNo() - 1);
				insertSkillByXmlNode(skill, root);
			} else {
				logger.info("节点名称："+rootName+"，共有相同节点名称"+skillsSameName.size()+"个");
				map.put("errorNo", -1);
				map.put("errorInfo", "节点不存在或节点同时存在两个同名的");
			}
		} else {
			map.put("errorNo", -2);
			map.put("errorInfo", "节点错误");
		}
		return map;
	}
	
	/**
	 * 根据文件获取根节点
	 * @param file
	 * @param request
	 * @return
	 */
	public Element getRootElementByXmlFile(MultipartFile file, HttpServletRequest request) {
		String filePath = FileUtils.restoreFile(file, request);
		File fileR = new File(filePath);
		
		if (fileR.exists()) {
			SAXReader sr = new SAXReader();  
	        try {  
	            Document doc  =  sr.read(fileR);  
	            Element root = doc.getRootElement();
	            Iterator rootNodes = root.elementIterator();
	            if (rootNodes.hasNext()) {
	            	return (Element) rootNodes.next();
	            }
	        } catch (DocumentException e) {  
	            e.printStackTrace();  
	        }
		}
		return null;
	}
	
	/**
	 * 递归插入xml文件内所有节点
	 * @param parentId 父节点ID
	 * @param root
	 * @return
	 */
	public void insertSkillByXmlNode(Skill parentSkill, Element root) {
		Iterator childs = root.elementIterator();
		while(childs.hasNext()) {
			Element node = (Element) childs.next();
			Skill skill = new Skill(node.attributeValue("TEXT"), "", new Date(), parentSkill.getUserId());
			skill = insertSkill(skill, parentSkill);
			if (node.elementIterator().hasNext()) {
				insertSkillByXmlNode(skill, node);
			}
		}
	}

	@Override
	public List<Skill> querySkillsByCreateTimeAndAlertType(Date time,
			Integer alertType, Integer userId) {
		return skillDao.querySkillsByCreateTimeAndAlertType(time, alertType, userId);
	}

	@Override
	public Integer updateSkillAlertType(Integer skillID, Integer alertType) {
		Skill skill = getBySkillID(skillID);
		skill.setAlertType(alertType);
		return skillDao.updateSkillAlertType(skill);
	}

	@Override
	public Integer updateSkillIsAlert(Skill skill) {
		return skillDao.updateSkillIsAlert(skill);
	}

	
	
	

}

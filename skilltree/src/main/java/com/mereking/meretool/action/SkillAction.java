package com.mereking.meretool.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mereking.meretool.dto.InsertSkillDTO;
import com.mereking.meretool.dto.QueryAllSkillDTO;
import com.mereking.meretool.dto.QuerySkillLinkDTO;
import com.mereking.meretool.dto.QuerySkillLinkResultDTO;
import com.mereking.meretool.dto.QuerySkillsByLayerAjaxVO;
import com.mereking.meretool.dto.SkillAjaxLinkVO;
import com.mereking.meretool.dto.SkillAjaxNodeVO;
import com.mereking.meretool.dto.UpdateSkillDTO;
import com.mereking.meretool.dto.UpdateUserDTO;
import com.mereking.meretool.entity.Skill;
import com.mereking.meretool.entity.User;
import com.mereking.meretool.service.SkillService;
import com.mereking.meretool.service.UserService;

@Controller
@RequestMapping("/skill")
public class SkillAction {
	@Autowired
	private SkillService skillService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/querySkillTree")
	public String querySkillTree() {
		return "skill/skill_tree";
	}
	
	
	@RequestMapping("/queryAllSkill")
	public String queryAllSkill(QueryAllSkillDTO queryAllSkillDTO, Model model, HttpServletRequest request) {
		// 获取用户查询记录
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			user = userService.getByUsername("default");
		}
		Integer lastSkillLayer = user.getLastSkillLayer();
		Integer lastSkillID = user.getLastSkillID();
		Integer lastSkillLayerNum = user.getLastSkillLayerNum();
		// 判断记录与查询
		if (queryAllSkillDTO.getLayer() == null) {
			queryAllSkillDTO.setLayer(lastSkillLayer);
		} else {
			lastSkillLayer = queryAllSkillDTO.getLayer();
		}
		if (queryAllSkillDTO.getSkillID() == null) {
			queryAllSkillDTO.setSkillID(lastSkillID);
		} else {
			lastSkillID = queryAllSkillDTO.getSkillID();
		}
		if (queryAllSkillDTO.getLayerNum() == null) {
			queryAllSkillDTO.setLayerNum(lastSkillLayerNum);
		} else {
			lastSkillLayerNum = queryAllSkillDTO.getLayerNum();
		}
		queryAllSkillDTO.setUserId(user.getId());
		
		// 记录用户查询
		UpdateUserDTO updateUserDTO = new UpdateUserDTO();
		updateUserDTO.setUsername(user.getUsername());
		updateUserDTO.setLastSkillLayer(lastSkillLayer);
		updateUserDTO.setLastSkillID(lastSkillID);
		updateUserDTO.setLastSkillLayerNum(lastSkillLayerNum);
		userService.updateUserType(updateUserDTO);

		// 开始查询
		List<Skill> skills = skillService.queryALLSkill(queryAllSkillDTO);
		model.addAttribute("skills", skills);
		model.addAttribute("username", user.getUsername());
		model.addAttribute("lastSkillLayer", lastSkillLayer);
		model.addAttribute("lastSkillID", lastSkillID);
		model.addAttribute("lastSkillLayerNum", lastSkillLayerNum);
		return "skill/skill_list";
	}
	
	@RequestMapping("/querySkillsByLayer")
	@ResponseBody
	public Map<String, Object> querySkillsByLayer(Integer layer, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		
		if (layer == null) {
			layer = 1;
		}
		List<Skill> skills = skillService.querySkillsByLayer(layer, user.getId());
		List<QuerySkillsByLayerAjaxVO> querySkillsByLayerAjaxVOs = new ArrayList<QuerySkillsByLayerAjaxVO>();
		// 增加技能
		for (Skill skill : skills) {
			QuerySkillsByLayerAjaxVO querySkillsByLayerAjaxVO = new QuerySkillsByLayerAjaxVO(skill);
			querySkillsByLayerAjaxVOs.add(querySkillsByLayerAjaxVO);
		}
		
		Map<String, Object> result = new HashedMap();
		result.put("errorNo", 0);
		result.put("errorInfo", "");
		result.put("querySkillsByLayerAjaxVOs", querySkillsByLayerAjaxVOs);
		return result;
	}
	
	@RequestMapping("/queryAllSkillAjax")
	@ResponseBody
	public Map<String, Object> queryAllSkillAjax(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		QuerySkillLinkDTO querySkillLinkDTO = new QuerySkillLinkDTO();
		querySkillLinkDTO.setUserId(user.getId());
		List<QuerySkillLinkResultDTO> querySkillLinkResultDTOs = skillService.querySkillLink(querySkillLinkDTO);
		// 定义节点
		List<SkillAjaxNodeVO> nodes = new ArrayList<SkillAjaxNodeVO>();
		// 定义关联关系
		List<SkillAjaxLinkVO> links = new ArrayList<SkillAjaxLinkVO>();
		
		// 增加根节点
		SkillAjaxNodeVO root = new SkillAjaxNodeVO(1, "根节点", 0);
		nodes.add(root);
		// 增加节点及关联关系
		for (QuerySkillLinkResultDTO querySkillLinkResultDTO : querySkillLinkResultDTOs) {
			SkillAjaxNodeVO skillAjaxNodeVO = new SkillAjaxNodeVO(querySkillLinkResultDTO);
			nodes.add(skillAjaxNodeVO);
			SkillAjaxLinkVO skillAjaxLinkVO = new SkillAjaxLinkVO(querySkillLinkResultDTO);
			links.add(skillAjaxLinkVO);
		}
		
		Map<String, Object> result = new HashedMap();
		result.put("nodes", nodes);
		result.put("links", links);
		return result;
	}
	
	@RequestMapping("/getSkillBySkillID")
	public String getSkillBySkillID(Integer skillID, Model model) {
		Skill skill = skillService.getBySkillID(skillID);
		model.addAttribute("skill", skill);
		return "skill/skill_view";
	}
	
	@RequestMapping("/insertSkillPage")
	public String gotoInsertSkill(Integer parentSkillID, Model model, HttpServletRequest request) {
		Skill skill = skillService.getBySkillID(parentSkillID);
		model.addAttribute("skill", skill);
		return "skill/skill_insert";
	}
	
	@RequestMapping("/insertSkill")
	public String insertSkill(InsertSkillDTO insertSkillDTO, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		insertSkillDTO.setUserId(user.getId());
		skillService.insertSkill(insertSkillDTO);
		return "redirect:queryAllSkill";
	}
	
	@RequestMapping("/updateSkillPage")
	public String gotoUpdateSkill(Integer skillID, Model model, HttpServletRequest reqeust) {
		Skill skill = skillService.getBySkillID(skillID);
		model.addAttribute("skill", skill);
		return "skill/skill_update";
	}
	
	@RequestMapping("/updateSkill")
	public String updateSkill(UpdateSkillDTO updateSkillDTO, Model model) {
		skillService.updateSkill(updateSkillDTO);
		model.addAttribute("skillID", updateSkillDTO.getSkillID());
		return "redirect:queryAllSkill";
	}
	
	@RequestMapping("/deleteSkill")
	public String deleteSkill(Integer skillID) {
		skillService.deleteSkill(skillID);
		return "redirect:queryAllSkill";
	}
	
	@RequestMapping("/updateIncreaseSkillLevel")
	public String updateIncreaseSkillLevel(Integer skillID) {
		skillService.updateIncreaseSkillLevel(skillID);
		return "redirect:queryAllSkill";
	}
	@RequestMapping("/updateDecreaseSkillLevel")
	public String updateDecreaseSkillLevel(Integer skillID) {
		skillService.updateDecreaseSkillLevel(skillID);
		return "redirect:queryAllSkill";
	}
	/**
	 * 跳转至思维导图导入页面
	 * @param skillID
	 * @return
	 */
	@RequestMapping("/importXmindFilePage")
	public String importXmindFilePage(Integer skillID) {
		return "skill/xmind_import";
	}
	
	/**
	 * 导入思维导图技能
	 * @param xmindFile
	 * @param model
	 * @return
	 */
	@RequestMapping("/importXmindFile")
	@ResponseBody
	public Map<String, Object> importXmindFile(@RequestParam("xmindFile")MultipartFile xmindFile, HttpServletRequest request, Model model) {
		User user = (User) request.getSession().getAttribute("user");
		return skillService.importXmindFile(user.getId(), xmindFile, request);
	}

}

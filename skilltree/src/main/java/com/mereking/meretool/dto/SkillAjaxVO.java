package com.mereking.meretool.dto;

import java.util.List;

/**
 * 显示关联关系
 * @author mereking
 *
 */
public class SkillAjaxVO {
	private List<SkillAjaxLinkVO> links;
	private List<SkillAjaxNodeVO> nodes;
	public List<SkillAjaxLinkVO> getLinks() {
		return links;
	}
	public void setLinks(List<SkillAjaxLinkVO> links) {
		this.links = links;
	}
	public List<SkillAjaxNodeVO> getNodes() {
		return nodes;
	}
	public void setNodes(List<SkillAjaxNodeVO> nodes) {
		this.nodes = nodes;
	}

	
	

}

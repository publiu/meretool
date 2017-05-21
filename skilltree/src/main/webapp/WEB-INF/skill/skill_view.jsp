<%@ page language="Java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="navbar">
  <div class="navbar-inner">
    <div class="left"><a href="#" class="back link"> <i class="icon icon-back"></i><span>返回</span></a></div>
    <div class="center sliding">技能详情</div>
    <div class="right">
    	
    </div>
  </div>
</div>
<div class="pages navbar-through toolbar-through">
  <!-- Page, data-page contains page name-->
  <div data-page="skill_view" class="page navbar-fixed">

	<div class="page-content">
		
		<div class="content-block-title">${skill.skillName}-等级${skill.skillLevel }</div>
		  <!-- Inset content block -->
		  <div class="content-block inset">
		    <div class="content-block-inner">
		      <p>${skill.skillDetail }</p>
		    </div>
		  </div>
		    <p class="buttons-row">
			  <a href="updateIncreaseSkillLevel.action?skillID=${skill.skillID}" class="button button-round">提升</a>
			  <a href="updateDecreaseSkillLevel.action?skillID=${skill.skillID}" class="button button-round">降低</a>
			</p>
			<p><a href="updateSkillPage.action?skillID=${skill.skillID}" class="button button-round button-fill color-green ">修改</a></p>
			<p><a href="insertSkillPage.action?parentSkillID=${skill.skillID}" class="button button-round button-fill color-green ">添加</a></p>
			<p><a href="#" onclick="confirm('确定要删除？','deleteSkill.action?skillID=${skill.skillID}')" class="button button-round button-fill color-red ">删除</a></p>

		</div>
	</div>
	
</div>

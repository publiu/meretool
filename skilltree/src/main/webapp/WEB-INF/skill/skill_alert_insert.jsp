<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
    <div class="center sliding">添加提示</div>
    <div class="right">
    	
    </div>
  </div>
</div>

<div class="pages navbar-through toolbar-through">
  <!-- Page, data-page contains page name-->
  <div data-page="skill_view" class="page">

	<div class="page-content">
		
		<div class="content-block-title">提示</div>
		  <form action="./insertAlertSkill.action" method="post">
		  <input type="hidden" name="parentSkillID" value="${skill.skillID}" />
				<div class="list-block inset">
				  <ul>
				    <!-- Text inputs -->
				    <li>
				      <div class="item-content">
				        <div class="item-media"><i class="icon icon-form-name"></i></div>
				        <div class="item-inner">
				          <div class="item-title label">内容</div>
				          <div class="item-input">
				            <input type="text" name="skillName" value="" />
				          </div>
				        </div>
				      </div>
				    </li>
				    <!-- Text inputs -->
				    <li>
				      <div class="item-content">
				        <div class="item-media"><i class="icon icon-form-name"></i></div>
				        <div class="item-inner">
				          <div class="item-title label">时间</div>
				          <div class="item-input">
				            <input type="text" name="skillCreate" value="${now }" />
				          </div>
				        </div>
				      </div>
				    </li>
				    <li class="align-top">
				      <div class="item-content">
				        <div class="item-media"><i class="icon icon-form-comment"></i></div>
				        <div class="item-inner">
				          <div class="item-title label">描述</div>
				          <div class="item-input">
				            <textarea name="skillDetail"></textarea>
				          </div>
				        </div>
				      </div>
				    </li>
				  </ul>
				</div>
				<div class="content-block">
			        <div class="row">
			          <div class="col-100">
			            <input type="submit" value="提交" class="button button-big button-fill color-green"/>
			          </div>
			        </div>
			    </div>
			</form>
	</div>
  </div>
</div>



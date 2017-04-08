<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="Java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

<!-- jQuery AND jQueryUI -->
<script type="text/javascript" src="../third-resources/OA_coreadmin/js/libs/jquery/1.6/jquery.min.js"></script>
<script type="text/javascript" src="../third-resources/OA_coreadmin/js/libs/jqueryui/1.8.13/jquery-ui.min.js"></script>

<link rel="stylesheet" href="../third-resources/OA_coreadmin/css/min.css" />
<script type="text/javascript" src="../third-resources/OA_coreadmin/js/min.js"></script>
<script type="text/javascript" src="../third-resources/OA_coreadmin/content/settings/main.js"></script>
<link rel="stylesheet" href="../third-resources/OA_coreadmin/content/settings/style.css" />

<style>

.links line {
  stroke: #999;
  stroke-opacity: 0.6;
}

.nodes circle {
  stroke: #fff;
  stroke-width: 1.5px;
}

</style>

</head>
<body>

<table>
	<tr><td>父技能名称：${skill.skillName}</td></tr>
</table>
<form action="/skill/insertSkill.action" method="post">
	<input type="hidden" name="parentSkillID" value="${skill.skillID}" />
	技能名称：<input type="text" name="skillName" value="" /><br/>
	技能描述：<textarea rows="20" cols="" name="skillDetail" ></textarea><br/>
	<input type="submit" value="提交" />
</form>




</body>
</html>

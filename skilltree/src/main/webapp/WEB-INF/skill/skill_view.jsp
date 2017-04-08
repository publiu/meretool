<%@ page language="Java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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

<body url="">
<div id="content" class="white">
<div class="bloc">
    <div class="title">${skill.skillName}-等级${skill.skillLevel }</div>
    <div class="content">
    	${skill.skillDetail }

            <p>
                <a href="insertSkillPage.action?parentSkillID=${skill.skillID}" class="button black">添加</a>
                <a href="updateIncreaseSkillLevel.action?skillID=${skill.skillID}" class="button black">提升</a>
                <a href="updateDecreaseSkillLevel.action?skillID=${skill.skillID}" class="button black">降低</a>
            </p>

        <div class="cb"></div>
    </div>
</div>
</div>
        
        
</body>
</html>

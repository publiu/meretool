<%@ page language="Java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<body>
<c:forEach var="skill" items="${skills}">
	<c:if test="${skill.layer==1}">
		>>
	</c:if>
	<c:if test="${skill.layer==2}">
		>>>>>>>>
	</c:if>
	<c:if test="${skill.layer==3}">
		>>>>>>>>>>>>>>>>
	</c:if>
	${skill.skillName}<br/>
</c:forEach>
</body>
</html>

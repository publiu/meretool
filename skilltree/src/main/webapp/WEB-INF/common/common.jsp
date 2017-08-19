<%@ page language="Java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- Required meta tags-->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
<meta name="apple-mobile-web-app-capable" content="yes">
<!-- Color theme for statusbar -->
<meta name="theme-color" content="#2196f3">
<!-- Path to Framework7 Library CSS-->
<link rel="stylesheet" href="../third-resources/framework7/css/framework7.ios.min.css">
<link rel="stylesheet" href="../third-resources/framework7/css/framework7.ios.colors.min.css">
<!-- Path to your custom app styles-->
<link rel="stylesheet" href="../third-resources/framework7/css/my-app.css">

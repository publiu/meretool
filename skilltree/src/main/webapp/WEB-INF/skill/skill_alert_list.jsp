<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="Java" import="java.util.*" pageEncoding="UTF-8"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<style>

.links line {
  stroke: #999;
  stroke-opacity: 0.6;
}

.nodes circle {
  stroke: #fff;
  stroke-width: 1.5px;
}

      i.demo-icon-email {
        width: 24px;
        height: 24px;
        background-image: url("../third-resources/framework7/img/i-f7-ios.png");
      }
      i.demo-icon-calendar {
        width: 24px;
        height: 24px;
        background-image: url("data:image/svg+xml;charset=utf-8,<svg fill='#fff' height='24' viewBox='0 0 24 24' width='24' xmlns='http://www.w3.org/2000/svg'><path d='M17 12h-5v5h5v-5zM16 1v2H8V1H6v2H5c-1.11 0-1.99.9-1.99 2L3 19c0 1.1.89 2 2 2h14c1.1 0 2-.9 2-2V5c0-1.1-.9-2-2-2h-1V1h-2zm3 18H5V8h14v11z'/><path d='M0 0h24v24H0z' fill='none'/></svg>");
      }
      i.demo-icon-upload {
        width: 24px;
        height: 24px;
        background-image: url("data:image/svg+xml;charset=utf-8,<svg fill='#FFFFFF' height='24' viewBox='0 0 24 24' width='24' xmlns='http://www.w3.org/2000/svg'><path d='M0 0h24v24H0z' fill='none'/><path d='M9 16h6v-6h4l-7-7-7 7h4zm-4 2h14v2H5z'/></svg>");
      }
i.icon.icon-plus {
  width: 24px;
  height: 24px;
  font-size: 0;
  background-image: url("data:image/svg+xml;charset=utf-8,%3Csvg%20fill%3D'%23FFFFFF'%20height%3D'24'%20viewBox%3D'0%200%2024%2024'%20width%3D'24'%20xmlns%3D'http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg'%3E%3Cpath%20d%3D'M19%2013h-6v6h-2v-6H5v-2h6V5h2v6h6v2z'%2F%3E%3Cpath%20d%3D'M0%200h24v24H0z'%20fill%3D'none'%2F%3E%3C%2Fsvg%3E");
}
</style>
<%@include file="../common/common.jsp" %>
</head>

<body>
<!-- Views-->
    <div class="views">
      <!-- Your main view, should have "view-main" class-->
      <div class="view view-main">
       <!-- Top Navbar-->
       <div class="navbar">
         <div class="navbar-inner">
           <!-- We have home navbar without left link-->
           <div class="center sliding">提示</div>
           <div class="right">
             <!-- Right link contains only icon - additional "icon-only" class--><a href="#" class="link icon-only open-panel" onclick="login()"> <i class="icon icon-bars"></i></a>
           </div>
         </div>
       </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through">
          	<!-- Page, "data-page" contains page name -->
	          <div data-page="skill_list" class="page">

	            <!-- Scrollable page content -->
	            <div class="page-content">
					<div class="list-block">
						<div class="list-group">
						<c:forEach var="alertTypeEnum" items="${alertTypeEnums}" varStatus="status">
							<ul>
							    <li class="list-group-title">${alertTypeEnum.describe}</li>
								<c:forEach var="alertSkillList" items="${alertSkills}" varStatus="alertStatus">
									<c:if test="${status.index == alertStatus.index}">
										<c:forEach var="skill" items="${alertSkillList}" varStatus="alertStatus">
										
											<li class="item-content">
										      <div class="item-media">
											      <i class="icon icon-f7"></i>
										      </div>
										      <div class="item-inner">
										        <div class="item-title">
										        	<a href="getSkillBySkillID.action?skillID=${skill.skillID}">
										        	${skill.skillName}</a>
										        </div>
										        
										        <div class="item-after"><a href="updateSkillAlertType.action?skillID=${skill.skillID}&alertType=${skill.alertType+1}">
										        	。、。</a></div>

										      </div>
										    </li>
									    </c:forEach>
									 </c:if>
								</c:forEach>
						  	</ul>
						 </c:forEach> 		
						</div>
					</div>
				</div>	
			
			
			
			</div>
			<a href="#" class="floating-button floating-button-to-popover open-popover color-purple" style="margin-right:30px">
			    <i class="icon icon-plus" style="background-image:url('data:image/svg+xml;charset=utf-8,%3Csvg%20fill%3D'%23FFFFFF'%20height%3D'24'%20viewBox%3D'0%200%2024%2024'%20width%3D'24'%20xmlns%3D'http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg'%3E%3Cpath%20d%3D'M19%2013h-6v6h-2v-6H5v-2h6V5h2v6h6v2z'%2F%3E%3Cpath%20d%3D'M0%200h24v24H0z'%20fill%3D'none'%2F%3E%3C%2Fsvg%3E')"></i>
			</a>
			<!-- Popover -->
			<div class="popover demo-popover">
			  <div class="popover-inner">
			    <div class="list-block">
			      <ul>
			        <li>
			          <a href="#" class="item-content item-link" onclick="timeAlert();$$('.demo-popover').hide()">
			            <div class="item-inner">
			              <div class="item-title">时间列表</div>
			            </div>
			          </a>
			        </li>
			        <li>
			          <a href="#" class="item-content item-link" onclick="addAlert();$$('.demo-popover').hide()">
			            <div class="item-inner">
			              <div class="item-title">添加内容</div>
			            </div>
			          </a>
			        </li>
			        <li>
			          <a href="#" class="item-content item-link" onclick="test();$$('.demo-popover').hide()">
			            <div class="item-inner">
			              <div class="item-title">题目</div>
			            </div>
			          </a>
			        </li>
			      </ul>
			    </div>
			  </div>
			</div>
        </div>

			
      </div>
    </div>
    
  <%@include file="../common/framework_after.jsp" %>
</body>
</html>

<script src="../resources/js/d3/d3.v4.min.js"></script>
<script>
/* var id = navigator.userAgent.toString().toLowerCase().substring(33,45);
var spresult = id.split(" ");
id = spresult[0]; 
$$('#usernameID').val(id);*/
if (!checkLogin()) {
	login();
}
function addAlert() {
	mainView.router.loadPage("./insertAlertSkillPage.action?parentSkillID=1");
}

// 时间列表
function timeAlert() {
	// var content = "<br/>" + addDays(-15) + "<br/>" + addDays(-7) + "<br/>" + addDays(-4) + "<br/>" + addDays(-2) + "<br/>" + addDays(-1) + "<br/>" + addMinute(-12*60) + "<br/>" + addMinute(-30) + "<br/>" + addMinute(-5);
	var content = "<br/>" + addMinute(-5) + "<br/>" + addMinute(-30) + "<br/>" + addMinute(-12*60) + "<br/>" + addDays(-1) + "<br/>" + addDays(-2) + "<br/>" + addDays(-4) + "<br/>" + addDays(-7) + "<br/>" + addDays(-15);
	myApp.alert(content,"时间点列表");
}

// 校验是否登录
function checkLogin() {
	var result = false;
	myApp.showPreloader("校验登录情况");
	$$.ajax({
		url : '../checkLogin.do',
		type : 'POST',
		async : false,
		success : function(data) {
			myApp.hidePreloader();
			data = JSON.parse(data);
			if (data.errorNo == 0) {
				result = true;
			}
		}
	});
	return result;
}
// 登录登出操作
function login() {
	myApp.modalPassword('', '登录', function (id) {
    	myApp.showPreloader("校验中");
    	$$.ajax({
    		url : '../login.do',
    		type : 'POST',
    		data : {
    			'id' : id
    		},
    		success : function(data) {
    			myApp.hidePreloader();
    			data = JSON.parse(data);
    			if (data.errorNo == 0) {
    		        mainView.refreshPage();
    			} else {
    				myApp.alert(data.errorInfo);
    				login();
    			}
    		}
    		
    	});
        
    }, function() {
    	// 删除cookie
    	//setCookie("id", "", -1);
    	//login();
    	myApp.showPreloader("校验中");
    	$$.ajax({
    		url : '../logout.do',
    		type : 'POST',
    		success : function(data) {
    			myApp.hidePreloader();
    			data = JSON.parse(data);
    			myApp.alert(data.errorInfo);
    		}
    		
    	});
    });
}

var length = 1;
var testAllNo = 0;
function GetRandomNum(Min,Max)
{   
	var Range = Max - Min;   
	var Rand = Math.random();   
	return (Min + Math.round(Rand * Range));   
}  
function test() {
	var no1 = GetRandomNum(length,length*10-1);
	var no2 = GetRandomNum(length,length*10-1);
	var resultTest = 0;
	var opNo = GetRandomNum(1,3);
	var op = "";
	if (opNo == 1) {
		op = "+";
		resultTest = no1 + no2;
	}
	else if (opNo == 2) {
		op = "-";
		resultTest = no1 - no2;
	}
	else if (opNo == 3) {
		op = "X";
		resultTest = no1 * no2;
	}
	
	myApp.modalPassword('', '测试<br/>'+no1+"<br/>"+op+"<br/>"+no2, function (result) {
		
		var callback = function () {
			if (testAllNo == 9) {
				length = length*10;
				testAllNo = 0;
			} else {
				testAllNo = testAllNo + 1;
			}
			
			test();
		}
		if (result == resultTest) {
			myApp.alert("回答正确","",callback);
		} else {
			myApp.alert("回答错误","",callback);
		}
		
    },function () {
		length = 1;
	});
}



//日期加上天数后的新日期. 
function addDays(days) { 
	var nd = new Date();   
	nd = nd.valueOf();   
	nd = nd + days * 24 * 60 * 60 * 1000;   
	nd = new Date(nd);   //alert(nd.getFullYear() + "年" + (nd.getMonth() + 1) + "月" + nd.getDate() + "日"); 
	var y = nd.getFullYear(); 
	var m = nd.getMonth()+1; 
	var d = nd.getDate(); 
	if(m <= 9) m = "0"+m; 
	if(d <= 9) d = "0"+d;  
	var cdate = y+"年"+m+"月"+d+"日"; 
	return cdate;
}
// 当前时分加上分钟数后的新时间
function addMinute(minutes) { 
	var nd = new Date();   
	nd = nd.setMinutes(nd.getMinutes()+minutes);
	nd = new Date(nd);
	var hours = nd.getHours();
	var minutess = nd.getMinutes();
	if(hours <= 9) hours = "0" + hours;
	if(minutess <= 9) minutess = "0" + minutess;
	
	var mdate = hours+"时"+minutess+"分"; 
	return mdate;
}




</script>

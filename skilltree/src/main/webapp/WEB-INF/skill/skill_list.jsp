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
           <div class="center sliding">技能树</div>
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
				  <form action="queryAllSkill.action" method="post">
				  	   <input type="hidden" name="username" id="usernameID"/>
				  	   <input type="hidden" name="lastSkillID" id="lastSkillID" value="${lastSkillID}"/>
					   <div class="list-block">
						  <ul>
						    <li>
						      <!-- Smart select, will be opened in Picker with custom height -->
						      <a href="#" class="item-link smart-select" data-open-in="picker" data-picker-height="400px" data-picker-close-text="关闭">
						       <!-- select -->
						        <select name="layer" id="layerID"  onchange="querySkillsByLayer()">
						          <c:forEach var="no" begin="1" end="20">
						          	<c:choose>
						          		<c:when test="${no==lastSkillLayer}">
						          			<option value="${no}" selected>${no}</option>
						          		</c:when>
						          		<c:otherwise>
						          			<option value="${no}">${no}</option>
						          		</c:otherwise>
						          	
						          	</c:choose>
						          	
								  </c:forEach>
						          
						        </select>
						        <div class="item-content">
						          <div class="item-inner">
						            <!-- Select label -->
						            <div class="item-title">层次</div>
						            <!-- Selected value, not required -->
						            <div class="item-after">${lastSkillLayer}</div>
						          </div>
						        </div>
						      </a>
						    </li>
						    <li>
						      <!-- Smart select, will be opened in Picker with custom height -->
						      <a href="#" class="item-link smart-select" data-open-in="picker" data-picker-height="400px" data-picker-close-text="关闭">
						       <!-- select -->
						        <select name="skillID" id="skillID">
						        </select>
						        <div class="item-content">
						          <div class="item-inner">
						            <!-- Select label -->
						            <div class="item-title">技能</div>
						            <!-- Selected value, not required -->
						            <div class="item-after" id="skillIDShow"></div>
						          </div>
						        </div>
						      </a>
						    </li>
						    <li>
						    <!-- Smart select, will be opened in Picker with custom height -->
						    <a href="#" class="item-link smart-select" data-open-in="picker" data-picker-height="400px" data-picker-close-text="关闭">
						       <!-- select -->
						        <select name="layerNum">
						        <c:forEach var="no" begin="1" end="20">
						          <c:choose>
					          		<c:when test="${no==lastSkillLayerNum}">
					          			<option value="${no}" selected>${no}</option>
					          		</c:when>
					          		<c:otherwise>
					          			<option value="${no}">${no}</option>
					          		</c:otherwise>
						          	
						          </c:choose>
						        </c:forEach>
						        </select>
						        <div class="item-content">
						          <div class="item-inner">
						            <!-- Select label -->
						            <div class="item-title">深度</div>
						            <!-- Selected value, not required -->
						            <div class="item-after">${lastSkillLayerNum}</div>
						          </div>
						        </div>
						      </a>
						    </li>
						    <li>
						    </li>
						  </ul>
						</div>

						<div class="content-block">
					        <div class="row">
					          <div class="col-100">
					            <input type="submit" onclick="waiting()" value="提交" class="button button-big button-fill color-green"/>
					          </div>
					        </div>
					    </div>
					</form>
	            	
	            
					<div class="list-block">
						<div class="list-group">
							<ul>
							    <li class="list-group-title">技能树</li>
								<c:forEach var="skill" items="${skills}">
									<li class="item-content">
								      <div class="item-media">
									      <i class="icon icon-f7"></i>
								      </div>
								      <div class="item-inner">
								        <div class="item-title">
								        	<a href="getSkillBySkillID.action?skillID=${skill.skillID}">
								        	<c:forEach var="no" begin="1" end="${skill.layer-lastSkillLayer}">　</c:forEach>
								        	${skill.skillName}</a>
								        </div>
								        <c:if test="${(skill.rightSkillNo-skill.leftSkillNo)<=1}">
								        <div class="item-after"><span class="badge">${skill.skillLevel }</span></div>
								        </c:if>
								      </div>
								    </li>
								</c:forEach>
						  	</ul>	
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
} else {
	init();
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
			myApp.alert("回答正确",callback);
		} else {
			myApp.alert("回答错误",callback);
		}
		
    },function () {
		length = 1;
	});
}

var defaultSkillID;
function init() {
	defaultSkillID=$$("#lastSkillID").val();
	// 加载后运行一次
	querySkillsByLayer();
}


function querySkillsByLayer() {
	var layer = $$('#layerID').val();
	myApp.showPreloader("正在查找第"+layer+"层技能");
	$$.ajax({
		url : 'querySkillsByLayer.do?rnd=' + new Date().getTime(),
		type : 'POST',
		data : {
			'layer' : layer
		},
		success : function(data) {
			data = JSON.parse(data);
			myApp.hidePreloader();
			if (data.errorNo == 0) {
				if (data.querySkillsByLayerAjaxVOs == null || data.querySkillsByLayerAjaxVOs.length < 1) {
					myApp.alert("第"+layer+"层无技能","提示");
				} else {
					$$('#skillID').html("");
					var isSelected = false;
					for(var i=0; i<data.querySkillsByLayerAjaxVOs.length; i++) {
						var skill = data.querySkillsByLayerAjaxVOs[i];
						if (skill.skillID == defaultSkillID) {
							$$('#skillID').append('<option value="'+skill.skillID+'" selected>'+skill.skillName+'</option>');
							$$('#skillIDShow').html(skill.skillName);
							isSelected = true;
						} else {
							$$('#skillID').append('<option id="skillOption'+i+'" value="'+skill.skillID+'">'+skill.skillName+'</option>');
						}
					}
					if(!isSelected) {
						$$('#skillOption0').attr('selected', true);
						$$('#skillIDShow').html($$('#skillOption0').html());
					}
				}
				

			} else {
				myApp.alert("提示",data.errorInfo);
			}
		}
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





var svg = d3.select("svg"),
    width = +svg.attr("width"),
    height = +svg.attr("height");

var color = d3.scaleOrdinal(d3.schemeCategory20);

var simulation = d3.forceSimulation()
    .force("link", d3.forceLink().id(function(d) { return d.id; }))
    .force("charge", d3.forceManyBody())
    .force("center", d3.forceCenter(width / 2, height / 2));

d3.json("queryAllSkillAjax.action", function(error, graph) {
  if (error) throw error;

  var link = svg.append("g")
      .attr("class", "links")
    .selectAll("line")
    .data(graph.links)
    .enter().append("line")
      .attr("stroke-width", function(d) { return Math.sqrt(d.value); });

  var node = svg.append("g")
      .attr("class", "nodes")
    .selectAll("circle")
    .data(graph.nodes)
    .enter().append("circle")
      .attr("r", 5)
      .attr("fill", function(d) { return color(d.group); })
      .call(d3.drag()
          .on("start", dragstarted)
          .on("drag", dragged)
          .on("end", dragended));

  node.append("title")
      .text(function(d) { return d.title; });

  simulation
      .nodes(graph.nodes)
      .on("tick", ticked);

  simulation.force("link")
      .links(graph.links);

  function ticked() {
    link
        .attr("x1", function(d) { return d.source.x; })
        .attr("y1", function(d) { return d.source.y; })
        .attr("x2", function(d) { return d.target.x; })
        .attr("y2", function(d) { return d.target.y; });

    node
        .attr("cx", function(d) { return d.x; })
        .attr("cy", function(d) { return d.y; });
  }
});

function dragstarted(d) {
  if (!d3.event.active) simulation.alphaTarget(0.3).restart();
  d.fx = d.x;
  d.fy = d.y;
}

function dragged(d) {
  d.fx = d3.event.x;
  d.fy = d3.event.y;
}

function dragended(d) {
  if (!d3.event.active) simulation.alphaTarget(0);
  d.fx = null;
  d.fy = null;
}

</script>

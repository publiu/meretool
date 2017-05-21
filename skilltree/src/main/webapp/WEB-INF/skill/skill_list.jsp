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
if (!document.cookie) {
	login();
} else {
	init();
}

function login() {
	myApp.modalPassword('', '登录', function (id) {
    	myApp.showPreloader("校验中");
    	$$.ajax({
    		url : '../queryUserId.do',
    		type : 'POST',
    		data : {
    			'id' : id
    		},
    		success : function(data) {
    			myApp.hidePreloader();
    			data = JSON.parse(data);
    			if (data.errorNo == 0) {
    				setCookie("id", id, 10);
    		        init();
    			} else {
    				myApp.alert(data.errorInfo);
    				login();
    			}
    		}
    		
    	});
        
    }, function() {
    	// 删除cookie
    	setCookie("id", "", -1);
    	login();
    });
}

//设置cookie
function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+d.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
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

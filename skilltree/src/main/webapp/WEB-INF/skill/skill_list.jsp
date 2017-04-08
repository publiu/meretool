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
    <div class="title">
        技能树
    </div>
    <div class="content">
        <table>

            <tbody>
	            <c:forEach var="skill" items="${skills}">
				<tr>
					<td>		
					<c:forEach var="no" begin="1" end="${skill.layer}">
						&nbsp
					</c:forEach>
						<a href="getSkillBySkillID.action?skillID=${skill.skillID}">${skill.skillName}</a>
						<br/>
					</td>
					<td>等级${skill.skillLevel }</td>
				</tr>
				</c:forEach>	
                <tr><td colspan="2"><svg width="960" height="600"></svg></td></tr> 
            </tbody>
        </table>

    </div>
</div>





</body>
</html>

<script src="../resources/js/d3/d3.v4.min.js"></script>
<script>

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
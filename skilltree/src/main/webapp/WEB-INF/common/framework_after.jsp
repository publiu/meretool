<!-- Path to Framework7 Library JS-->
<%@ page language="Java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript" src="../third-resources/framework7/js/framework7.min.js"></script>
<!-- Path to your app js-->
<script type="text/javascript" src="../third-resources/framework7/js/my-app.js"></script>
<script>
function confirm(msg, url) {
	myApp.confirm(msg,"提示", function () {
	    window.location.href=url;
	});
}
function waiting() {
	myApp.showPreloader("正在处理");
}
</script>
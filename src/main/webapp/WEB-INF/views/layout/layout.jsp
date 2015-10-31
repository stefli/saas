<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.synnex.saas.platform.constants.Constants"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SAAS测试系统 - ${sessionScope._tk }</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<!-- Bootstrap 3.3.2 -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet" type="text/css">
<!-- FontAwesome 4.3.0 -->
<link href="<c:url value="/resources/css/font-awesome.min.css" />"
	rel="stylesheet" type="text/css" />
<!-- Ionicons 2.0.0 -->
<link href="<c:url value="/resources/css/ionicons.min.css" />"
	rel="stylesheet" type="text/css" />
<!-- Theme style -->
<link href="<c:url value="/resources/css/AdminLTE.min.css" />"
	rel="stylesheet" type="text/css" />
<!-- AdminLTE Skins. Choose a skin from the css/skins 
         folder instead of downloading all of them to reduce the load. -->
<link href="<c:url value="/resources/css/skins/_all-skins.min.css" />"
	rel="stylesheet" type="text/css" />
<!-- iCheck -->
<link href="<c:url value="/resources/plugins/iCheck/flat/blue.css" />"
	rel="stylesheet" type="text/css" />
<!-- Morris chart -->
<link href="<c:url value="/resources/plugins/morris/morris.css" />"
	rel="stylesheet" type="text/css" />
<!-- jvectormap -->
<link
	href="<c:url value="/resources/plugins/jvectormap/jquery-jvectormap-1.2.2.css" />"
	rel="stylesheet" type="text/css" />
<!-- Date Picker -->
<link
	href="<c:url value="/resources/plugins/datepicker/datepicker3.css" />"
	rel="stylesheet" type="text/css" />
<!-- Daterange picker -->
<link
	href="<c:url value="/resources/plugins/daterangepicker/daterangepicker-bs3.css" />"
	rel="stylesheet" type="text/css" />
<!-- bootstrap wysihtml5 - text editor -->
<link
	href="<c:url value="/resources/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" />"
	rel="stylesheet" type="text/css" />
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="<c:url value="/resources/js/html5shiv.min.js" />"></script>
      <script src="<c:url value="/resources/js/respond.min.js" />"></script>
    <![endif]-->
</head>
<body class="skin-blue">
	<div class="wrapper">
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="menu" />
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					我的业务中心 <small>控制面板</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="glyphicon glyphicon-dashboard"></i>首页</a></li>
					<li class="active">我的业务中心</li>
				</ol>
			</section>
			<!-- Main content -->
			<section class="content">
				<tiles:insertAttribute name="content" />
			</section>
		</div>
		<tiles:insertAttribute name="footer" />
	</div>
	<!-- jQuery 2.1.3 -->
	<script src="<c:url value="/resources/js/jquery-1.11.2.min.js" />"></script>
	<!-- jQuery UI 1.11.2 -->
	<script src="<c:url value="/resources/js/jquery-ui.min.js" />"
		type="text/javascript"></script>
	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<script>
		$.widget.bridge('uibutton', $.ui.button);
	</script>
	<!-- Bootstrap 3.3.2 JS -->
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"
		type="text/javascript"></script>
	<!-- Morris.js charts -->
	<script
		src="<c:url value="/resources/plugins/raphael/raphael-min.js" />"></script>
	<script src="<c:url value="/resources/plugins/morris/morris.min.js" />"
		type="text/javascript"></script>
	<!-- Sparkline -->
	<script
		src="<c:url value="/resources/plugins/sparkline/jquery.sparkline.min.js" />"
		type="text/javascript"></script>
	<!-- jvectormap -->
	<script
		src="<c:url value="/resources/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js" />"
		type="text/javascript"></script>
	<script
		src="<c:url value="/resources/plugins/jvectormap/jquery-jvectormap-world-mill-en.js" />"
		type="text/javascript"></script>
	<!-- jQuery Knob Chart -->
	<script src="<c:url value="/resources/plugins/knob/jquery.knob.js" />"
		type="text/javascript"></script>
	<!-- daterangepicker -->
	<script
		src="<c:url value="/resources/plugins/daterangepicker/daterangepicker.js" />"
		type="text/javascript"></script>
	<!-- datepicker -->
	<script
		src="<c:url value="/resources/plugins/datepicker/bootstrap-datepicker.js" />"
		type="text/javascript"></script>
	<!-- Bootstrap WYSIHTML5 -->
	<script
		src="<c:url value="/resources/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js" />"
		type="text/javascript"></script>
	<!-- iCheck -->
	<script src="<c:url value="/resources/plugins/iCheck/icheck.min.js" />"
		type="text/javascript"></script>
	<!-- Slimscroll -->
	<script
		src="<c:url value="/resources/plugins/slimScroll/jquery.slimscroll.min.js" />"
		type="text/javascript"></script>
	<!-- FastClick -->
	<script
		src="<c:url value="/resources/plugins/fastclick/fastclick.min.js" />"></script>
	<!-- AdminLTE App -->
	<script src="<c:url value="/resources/js/app.min.js" />"
		type="text/javascript"></script>

	<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
	<script src="<c:url value="/resources/js/pages/dashboard.js" />"
		type="text/javascript"></script>

	<!-- AdminLTE for demo purposes -->
	<script src="<c:url value="/resources/js/demo.js" />"
		type="text/javascript"></script>
</body>
</html>

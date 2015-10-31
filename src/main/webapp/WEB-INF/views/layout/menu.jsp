<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="<c:url value="/resources/images/user2-160x160.jpg" />"
					class="img-circle" alt="User Image" />
			</div>
			<div class="pull-left info">
				<p>Steven Li</p>

				<a href="#"><i
					class="glyphicon glyphicon-ok-circle text-success"></i> Online</a>
			</div>
		</div>
		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">导航栏</li>
			<li class="treeview"><a href="#"> <i
					class="glyphicon glyphicon-dashboard"></i> <span>用户中心</span>
			</a>
				<ul class="treeview-menu">
					<li><a href="<c:url value="/profile"/>"><i
							class="glyphicon glyphicon-user"></i>个人信息</a></li>
					<li><a href="<c:url value="/profile"/>"><i
							class="glyphicon glyphicon-user"></i> 会员级别</a></li>
				</ul></li>
			<li class="active treeview"><a href="#"> <i
					class="glyphicon glyphicon-dashboard"></i> <span>业务管理</span>
			</a>
				<ul class="treeview-menu">
					<li class="active"><a href="<c:url value="/users" />"><i
							class="glyphicon glyphicon-cog"></i>用户管理</a></li>
					<li><a href="<c:url value="/roles" />"><i
							class="glyphicon glyphicon-cog"></i>角色管理</a></li>
					<li><a href="<c:url value="/resources" />"><i
							class="glyphicon glyphicon-cog"></i>资源管理</a></li>
					<li><a href="<c:url value="/organizations" />"><i
							class="glyphicon glyphicon-cog"></i>组织机构管理</a></li>
					<li><a href="<c:url value="/devices" />"><i
							class="glyphicon glyphicon-cog"></i>终端管理</a></li>
					<li><a href="<c:url value="/codeTypes" />"><i
							class="glyphicon glyphicon-cog"></i>代码类型管理</a></li>
					<li><a href="<c:url value="/codes" />"><i
							class="glyphicon glyphicon-cog"></i>代码管理</a></li>
					<li><a href="<c:url value="/tenants" />"><i
							class="glyphicon glyphicon-user"></i>租户管理</a></li>
					<li><a href="<c:url value="/undefined" />"><i
							class="glyphicon glyphicon-user"></i>字典表管理</a></li>
				</ul></li>
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>
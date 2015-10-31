<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="box box-primary">
	<div class="box-header">
		<h3 class="box-title">查看租户</h3>
	</div>
	<!-- /.box-header -->
	<!-- form start -->
	<form role="form">
		<div class="box-body">
			<div class="form-group">
				<label for="tenantId">租户编号</label> <input type="text"
					class="form-control" id="tenantId" value="${tenant.tenantId }"
					readonly="readonly">
			</div>
			<div class="form-group">
				<label for="name">租户名称</label> <input type="text"
					class="form-control" id="name" placeholder="输入名称"
					value="${tenant.name }" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="host">主机地址</label> <input type="text"
					class="form-control" id="host" placeholder="输入主机地址"
					value="${tenant.host }" readonly="readonly">
			</div>
		</div>
		<!-- /.box-body -->
		<div class="box-footer">
			<button type="button" class="btn btn-primary"
				onclick="history.back(-1);">返回</button>
		</div>
	</form>
</div>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="box box-primary">
	<div class="box-header">
		<h3 class="box-title">注册新租户</h3>
	</div>
	<!-- /.box-header -->
	<!-- form start -->
	<form role="form" name="frmTenantCreation"
		action="<c:url value="/tenant" />" method="post">
		<div class="box-body">
			<div class="form-group">
				<label for="name">租户名称</label> <input type="text"
					class="form-control" id="name" placeholder="输入名称">
			</div>
			<div class="form-group">
				<label for="host">主机地址</label> <input type="text"
					class="form-control" id="host" placeholder="输入主机地址">
			</div>
		</div>
		<!-- /.box-body -->
		<div class="box-footer">
			<button type="submit" class="btn btn-primary">保存</button>
		</div>
	</form>
</div>

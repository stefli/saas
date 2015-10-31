<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="panel panel-success">
	<div class="panel-heading">
		<h3 class="panel-title">业务说明</h3>
	</div>
	<div class="panel-body">可以修改和删除租户信息。</div>
</div>
<div class="box box-primary">
	<div class="box-header">
		<h3 class="box-title">修改租户</h3>
	</div>
	<!-- /.box-header -->
	<!-- form start -->
	<form role="form" name="frmTenantEdit"
		action="<c:url value="../${tenant.id }"/>" method="post">
		<input type="hidden" name="_method" value="PUT" />
		<div class="box-body">
			<div class="form-group">
				<label for="tenantId">租户编号</label> <input type="text"
					class="form-control" id="tenantId" value="${tenant.tenantId }"
					readonly="readonly">
			</div>
			<div class="form-group">
				<label for="name">租户名称</label> <input type="text"
					class="form-control" id="name" placeholder="输入名称"
					value="${tenant.name }">
			</div>
			<div class="form-group">
				<label for="host">主机地址</label> <input type="text"
					class="form-control" id="host" placeholder="输入主机地址"
					value="${tenant.host }">
			</div>
		</div>
		<!-- /.box-body -->
		<div class="box-footer">
			<button type="submit" class="btn btn-primary">保存</button>
			<button type="submit" class="btn btn-primary">删除</button>
		</div>
	</form>
</div>

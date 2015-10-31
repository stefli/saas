<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="s"%>
<a class="btn btn-primary" href="tenants/create">注册租户</a>
<a class="btn btn-primary" href="tenants/approve">审核租户</a>
<s:pagination results="${results}" />
<table
	class="table table-bordered table-hover table-condensed table-striped">
	<thead>
		<tr>
			<th width="20" align="center" style="text-align: center;"><input
				type="checkbox" class="form-control" /></th>
			<th width="30" align="center">序号.</th>
			<th width="44" align="center">操作</th>
			<th width="180">编号</th>
			<th width="100">租户名称</th>
			<th width="220">主机地址</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${results.content}" var="tenant" varStatus="status">
			<tr>
				<td align="center"><input type="checkbox" class="form-control" />
				</td>
				<td align="center">${status.index + 1 }</td>
				<td align="center"><a
					href="<c:url value="/tenant/${tenant.id}/edit"/>"
					class="glyphicon glyphicon-eye-open" title="查看租户" />&nbsp;<a
					href="#" class="glyphicon glyphicon-edit" title="修改租户" />&nbsp;<a
					href="#" class="glyphicon glyphicon-trash" title="删除租户" /></td>
				<td>${tenant.tenantId}</td>
				<td>${tenant.name}</td>
				<td>${tenant.host}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<s:pagination results="${results}" />
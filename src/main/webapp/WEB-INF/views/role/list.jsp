<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="s"%>
<a class="btn btn-primary" href="roles/create">新建角色</a>
<s:pagination results="${results}" />
<table
	class="table table-bordered table-hover table-condensed table-striped">
	<thead>
		<tr>
			<th width="30">No.</th>
			<th width="60">ID</th>
			<th width="220">Name</th>
			<th width="80">&nbsp;</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${results.content}" var="role">
			<tr>
				<td align="center"><input type="checkbox" class="form-control" />
				</td>
				<td><a href="role/${role.id}">${role.id}</a></td>
				<td>${role.name}</td>
				<td><a href="role/${role.id}/edit">Edit</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<s:pagination results="${results}" />
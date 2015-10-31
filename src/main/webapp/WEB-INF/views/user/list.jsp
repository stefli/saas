<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="s"%>
<a class="btn btn-primary" href="users/create">新建用户</a>
<s:pagination results="${results}" />
<table
	class="table table-bordered table-hover table-condensed table-striped">
	<thead>
		<tr>
			<th width="30">No.</th>
			<th width="60">ID</th>
			<th width="220">User Name</th>
			<th width="220">Nick Name</th>
			<th width="220">Register Date</th>
			<th width="80">&nbsp;</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${results.content}" var="user">
			<tr>
				<td align="center"><input type="checkbox" class="form-control" />
				</td>
				<td><a href="user/${user.id}">${user.id}</a></td>
				<td>${user.userName}</td>
				<td>${user.nickName}</td>
				<td>${user.registerDate}</td>
				<td><a href="user/${user.id}/edit">Edit</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<s:pagination results="${results}" />
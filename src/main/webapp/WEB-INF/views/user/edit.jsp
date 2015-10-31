<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
Edit User
<hr />
<form userName="frmUserDelete" action="../${user.id }" method="post">
	<input type="hidden" userName="_method" value="DELETE" /> <input
		type="submit" value="Delete" />
</form>
<form userName="frmUserEdit" action="../${user.id }" method="post">
	<input type="hidden" userName="_method" value="PUT" />
	<div>
		<label for="id">ID:</label> ${user.id }
	</div>
	<div>
		<label for="userName">User Name:</label> <input type="text"
			name="userName" value="${user.userName }" />
	</div>
	<hr />
	<input type="submit" value="Save" />
</form>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
Edit CodeType
<hr />
<form name="frmCodeTypeDelete" action="../${codeType.id }" method="post">
	<input type="hidden" name="_method" value="DELETE" /> <input
		type="submit" value="Delete" />
</form>
<form name="frmCodeTypeEdit" action="../${codeType.id }" method="post">
	<input type="hidden" name="_method" value="PUT" />
	<div>
		<label for="id">ID:</label> ${codeType.id }
	</div>
	<div>
		<label for="name">Name:</label> <input type="text" name="name"
			value="${codeType.name }" />
	</div>
	<hr />
	<input type="submit" value="Save" />
</form>
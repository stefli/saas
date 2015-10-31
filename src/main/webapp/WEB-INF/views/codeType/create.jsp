<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
Create CodeType
<form name="frmCodeTypeCreation" action="../codeType" method="post">
	<div>
		<label for="name">Name:</label> <input type="text" name="name"
			value="" />
	</div>
	<br /> <input type="submit" value="Save" />
</form>
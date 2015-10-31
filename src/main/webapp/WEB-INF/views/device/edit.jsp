<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
Edit Device
<hr />
<form name="frmDeviceDelete" action="../${device.id }" method="post">
	<input type="hidden" name="_method" value="DELETE" /> <input
		type="submit" value="Delete" />
</form>
<form name="frmDeviceEdit" action="../${device.id }" method="post">
	<input type="hidden" name="_method" value="PUT" />
	<div>
		<label for="id">ID:</label> ${device.id }
	</div>
	<div>
		<label for="name">Name:</label> <input type="text" name="name"
			value="${device.name }" />
	</div>
	<hr />
	<input type="submit" value="Save" />
</form>
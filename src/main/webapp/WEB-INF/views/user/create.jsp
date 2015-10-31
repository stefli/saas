<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="box box-primary">
	<div class="box-header">
		<h3 class="box-title">新建用户</h3>
	</div>
	<!-- /.box-header -->
	<!-- form start -->
	<form role="form" name="frmUserCreation"
		action="<c:url value="/user" />" method="post">
		<div class="box-body">
			<div class="form-group">
				<label for="userName">名称</label> <input type="text"
					class="form-control" id="userName" placeholder="输入名称" />
			</div>
			<div class="form-group">
				<label for="nickName">昵称</label> <input type="text"
					class="form-control" id="nickName" placeholder="输入昵称" />
			</div>
			<div class="form-group">
				<label for="registerTime">注册时间</label>
				<div class="input-append date" id="datetimepicker"
					data-date="12-02-2012" data-date-format="dd-mm-yyyy">
					<input class="span2" size="16" type="text" value="12-02-2012">
					<span class="add-on"><i class="icon-th"></i></span>
				</div>
			</div>
		</div>
		<!-- /.box-body -->
		<div class="box-footer">
			<button type="submit" class="btn btn-primary">保存</button>
		</div>
	</form>
</div>
<script type="text/javascript">
	$(function() {
		$('#datetimepicker').datetimepicker({
		    format: 'yyyy-mm-dd hh:ii'
		});
	});
</script>
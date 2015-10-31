<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="s"%>
<div class="panel panel-success">
	<div class="panel-heading">
		<h3 class="panel-title">API列表</h3>
	</div>
	<div class="panel-body">
		<table
			class="table table-bordered table-hover table-condensed table-striped">
			<thead>
				<tr>
					<th width="30">API地址</th>
					<th width="260">API说明</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>/api/tenants</td>
					<td>获取所有租户信息</td>
				</tr>
				<tr>
					<td>/api/orders</td>
					<td>获取所有订单信息</td>
				</tr>
				<tr>
					<td>/api/order/{id}</td>
					<td>获取特定订单的详细信息</td>
				</tr>
				<tr>
					<td>/api/order/{id}/approval</td>
					<td>审核订单</td>
				</tr>
				<tr>
					<td>/api/order/{id}/reject</td>
					<td>拒绝订单</td>
				</tr>
				<tr>
					<td>/api/shiporders</td>
					<td>获取所有运输订单信息</td>
				</tr>
				<tr>
					<td>/api/shiporder/{id}</td>
					<td>获取特定运输订单的详细信息</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
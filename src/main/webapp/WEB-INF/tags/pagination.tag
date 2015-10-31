<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="results" required="true" rtexprvalue="true"
	type="org.springframework.data.domain.Page"%>
<%
	int current = results.getNumber() + 1;
	int begin = Math.max(1, current - 5);
	int end = Math.min(begin + 10, results.getTotalPages());
	long totalCount = results.getTotalElements();

	request.setAttribute("totalCount", totalCount);
	request.setAttribute("current", current);
	request.setAttribute("begin", begin);
	request.setAttribute("end", end);
	request.setAttribute("total", results.getTotalPages());
%>
<nav>
	<ul class="pagination">
		<c:choose>
			<c:when test="${current == 1}">
				<li class="disabled"><a href="#">&lt;&lt;</a></li>
				<li class="disabled"><a href="#">&lt;</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="<c:url value="?page=1" />">&lt;&lt;</a></li>
				<li><a href="<c:url value="?page=${current - 1 }" />">&lt;</a></li>
			</c:otherwise>
		</c:choose>
		<c:forEach var="i" begin="${begin}" end="${end}">
			<li <c:if test="${i==current }"> class="active"</c:if>><a
				href="<c:url value="?page=${i }" />">${i}</a></li>
		</c:forEach>
		<c:choose>
			<c:when test="${current == results.totalPages}">
				<li class="disabled"><a href="#">&gt;</a></li>
				<li class="disabled"><a href="#">&gt;&gt;</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="<c:url value="?page=${current + 1 }" />">&gt;</a></li>
				<li><a href="<c:url value="?page=${results.totalPages }" />">&gt;&gt;</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</nav>
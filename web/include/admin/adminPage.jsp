<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
	$(function () {
		$("li.disabled").click(function () {
			return false;
		})
	})
</script>

<nav>
	<ul class="pagination">
		<li <c:if test="${not page.hasPrevious}">class="disabled"</c:if> >
			<a href="?page.start=0${page.param}">
				<span>«</span>
			</a>
		</li>
		
		<li <c:if test="${not page.hasPrevious}">class="disabled"</c:if> >
			<a href="?page.start=${page.start-page.count}${page.param}">
				<span>‹</span>
			</a>
		</li>
		
		<c:forEach begin="0" end="${page.totalPage-1}" varStatus="st">
			<c:if test="${st.count >= page.start/page.count + 1 and st.count <= page.start/page.count + 5}">
				<li <c:if test="${st.index * page.count == page.start}">class="disabled"</c:if> >
					<a href="?page.start=${st.index * page.count}${page.param}"
							<c:if test="${st.index * page.count == page.start}">style="font-weight: bold; color: #000;"</c:if> >
						<span>${st.count}</span>
					</a>
				</li>
			</c:if>
		</c:forEach>
		
		<li <c:if test="${not page.hasNext}">class="disabled"</c:if> >
			<a href="?page.start=${page.start+page.count}${page.param}">
				<span>›</span>
			</a>
		</li>
		
		<li <c:if test="${not page.hasNext}">class="disabled"</c:if> >
			<a href="?page.start=${page.last}${page.param}">
				<span>»</span>
			</a>
		</li>
	</ul>
</nav>

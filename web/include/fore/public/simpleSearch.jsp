<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link href="css/fore/public/simpleSearch.css" rel="stylesheet">

<div>
    <a href="${contextPath}">
        <img id="simpleLogo" src="img/site/simpleLogo.png">
    </a>
    <form action="foresearch" method="post">
        <div class="simpleSearchDiv pull-right">
            <input type="text" placeholder="平衡车 原汁机" name="keyword">
            <button class="searchButton" type="submit">搜天猫</button>
            <div class="simpleSearchBelow">
            	<c:forEach items="${cs}" var="c" varStatus="st">
            		<c:if test="${st.count >= 8 and st.count <= 11}">
            			<span>
                    		<a href="forecategory?cid=${c.id}">${c.name}</a>
                    		<c:if test="${st.count != 11}">
                    			<span>|</span>
                    		</c:if>
                		</span>
            		</c:if>
            	</c:forEach>
            </div>
        </div>
    </form>
</div>
<div style="clear: both"></div>

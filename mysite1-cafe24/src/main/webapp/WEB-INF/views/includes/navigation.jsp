<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  

<div id="navigation">
	<ul>
		<li class=${'main' eq param.menu ? 'selected' : '' }><a href="${pageContext.servletContext.contextPath}">안대혁</a></li>
		<li class=${'guestbook' eq param.menu ? 'selected' : '' }><a href="${pageContext.servletContext.contextPath}/guestbook">방명록</a></li>
		<li class=${'board' eq param.menu ? 'selected' : '' }><a href="${pageContext.servletContext.contextPath}/board?a=boardList">게시판</a></li>
	</ul>
</div>
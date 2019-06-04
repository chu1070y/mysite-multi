<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.servletContext.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="board">
				<form id="search_form" action="" method="post">
					<input type="text" id="kwd" name="kwd" value="">
					<input type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>
				
				<c:set var="count" value="${fn:length(boardList)}" />
				<c:forEach items="${boardList}" var="board" varStatus="status">		
					<tr>
						<td>${count - status.index}</td>
						<td><a href="">${board.title}</a></td>
						<td>${board.writer}</td>
						<td>${board.count}</td>
						<td>${board.regDate }</td>
						<td><c:if test="${authUser.no == board.writerNo }"><a href="" >삭제</a></c:if></td>
					</tr>
				</c:forEach>

				</table>
				<div class="bottom">
				
					<c:choose>
						<c:when test="${!empty authUser}">
							<a href="${pageContext.servletContext.contextPath}/board?a=writeform" id="new-book">글쓰기
							<input type="hidden" name="writerNo" value="" />
							</a>
						</c:when>
						
						<c:otherwise>
							글을 쓰려면 로그인을 해주세요
						</c:otherwise>
					</c:choose>
				

				</div>				
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp" >
			<c:param name="menu" value="board" />
		</c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	pageContext.setAttribute("newline", "\n");
%>  
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.servletContext.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/assets/js/jquery/jquery-1.9.0.js">
</script>
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="board">
				<form class="board-form" id="modify" method="post" action="${pageContext.servletContext.contextPath}/board/modify">
				<input type="hidden" name="no" value="${board.no }">
				<input type="hidden" name="writerNo" value="${board.writerNo }">
				<input type="hidden" name="page" id="page" value="${pageInfo.page}" />
				<input type="hidden" name="kwd" id="kwd" value="${pageInfo.kwd}" />
					<table class="tbl-ex">
						<tr>
							<th colspan="2">글수정</th>
						</tr>
						<tr>
							<td class="label">제목</td>
							<td><input type="text" name="title" value="${board.title }"></td>
						</tr>
						<tr>
							<td class="label">내용</td>
							<td>
								<textarea id="content" name="content">${board.content}</textarea>
							</td>
						</tr>
					</table>
					<div class="bottom">
						<a id="return" href="#">취소</a>
						<input type="submit" value="수정">
					</div>
				</form>				
			</div>
		</div>
		
		<form action="#" id="pageform">
			<input type="hidden" name="page" id="page" value="${pageInfo.page}" />
			<input type="hidden" name="kwd" id="kwd" value="${pageInfo.kwd}" />
		</form>
		
	<script>
	
	$(document).ready(function(){
		var pageform = $("#pageform");
		
		// 취소 클릭
		$("#return").click(function(e){
			e.preventDefault();
			pageform.attr("action","${pageContext.servletContext.contextPath}/board/read/${board.no}").attr("method","get").submit();
		});
		
		
	});
	
	</script>

		<c:import url="/WEB-INF/views/includes/navigation.jsp" >
			<c:param name="menu" value="board" />
		</c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>
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
			<div id="board" class="board-form">
				<table class="tbl-ex">
					<tr>
						<th colspan="2">글보기</th>
					</tr>
					<tr>
						<td class="label">제목</td>
						<td>${board.title }</td>
					</tr>
					<tr>
						<td class="label">내용</td>
						<td>
							<div class="view-content">
								${fn:replace(board.content,newline,"<br>") }
							</div>
						</td>
					</tr>
				</table>

				<div class="bottom">
					<a id="return" href="#">글목록</a>
					<c:if test="${authUser.no == board.writerNo}">
						<a  id="modify">글수정</a>
					</c:if>
					<c:choose>
						<c:when test="${!empty authUser}">
							<a id="responseWrite" href="#">답글달기</a>
						</c:when>
						
						<c:otherwise>
							답글을 쓰려면 로그인을 해주세요
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
	
		<form action="#" id="pageform">
			<input type="hidden" name="page" id="page" value="${pageInfo.page}" />
			<input type="hidden" name="kwd" id="kwd" value="${pageInfo.kwd}" />
		</form>
	
	<script>
	
	$(document).ready(function(){
		var pageform = $("#pageform");
		
		// 수정 버튼 클릭
		$("#modify").click(function(e){
			e.preventDefault();
			pageform.attr("action","${pageContext.servletContext.contextPath}/board/modify/${board.no}").attr("method","get").submit();
		});
		
		// 목록 돌아가기 클릭
		$("#return").click(function(e){
			e.preventDefault();
			pageform.attr("action","${pageContext.servletContext.contextPath}/board/list").attr("method","get").submit();
		});
		
		// 답글 달기 클릭
		$("#responseWrite").click(function(e){
			e.preventDefault();
			pageform.append("<input type'hidden' name='no' value='${board.no}' />");
			pageform.attr("action","${pageContext.servletContext.contextPath}/board/responseWrite").attr("method","get").submit();
		});
		
		
	});
	
	</script>
</body>
</html>
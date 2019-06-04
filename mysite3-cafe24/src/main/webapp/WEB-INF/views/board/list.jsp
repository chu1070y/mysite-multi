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
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/assets/js/jquery/jquery-1.9.0.js">
</script>
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="content">

			<div id="board">
				<form id="search_form" action="${pageContext.servletContext.contextPath}/board/list" method="get">
					<input type="text" id="kwd" name="kwd" value="${pageInfo.kwd }">
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
				
				<c:set var="count" value="${pageInfo.totalCount - pageInfo.display * (pageInfo.page - 1)}" />
				<c:forEach items="${boardList}" var="board" varStatus="status">		
					<tr>
						<c:choose>
							<c:when test="${board.del == 1}">
								<td></td>
								<td>삭제된 글입니다.</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</c:when>
							<c:otherwise>
									<td>${count-status.index}</td>
									<td style="text-align: left; padding-left: ${10*board.dept}px">
										<c:if test="${board.dept != 0}">
											<img
												src="${pageContext.servletContext.contextPath}/assets/images/reply.png" />
										</c:if> <a class="read" href="${board.no }">${board.title}</a>
									</td>

									<td>${board.writer}</td>
									<td>${board.count}</td>
									<td>${board.regDate }</td>
									<td><c:if test="${authUser.no == board.writerNo }">
											<form id="delete_form"
												action="${pageContext.servletContext.contextPath}/board/delete"
												method="post">
												<input type="hidden" name="no" value="${board.no}" />
												<input type="hidden" name="writerNo" value="${board.writerNo}" />
												<input type="hidden" name="page" value="${pageInfo.page}" />
												<a href="#" onclick="this.parentNode.submit()">삭제</a>
											</form>
										</c:if></td>
								</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>

				</table>
				
				<!-- pager 추가 -->
				<div class="pager">
					<ul>
						<li>
						<c:choose>
							<c:when test="${pageInfo.prevPage > 0}">
								<a href="${pageContext.servletContext.contextPath}/board/list?page=${pageInfo.prevPage}&kwd=${pageInfo.kwd}">◀</a>
							</c:when>
							<c:otherwise>
								◀
							</c:otherwise>
						</c:choose>
						</li>
						
						<c:forEach var="p" begin="${pageInfo.prevPage + 1}" end="${pageInfo.nextPage - 1 }" step="1">
							<li class="${pageInfo.page == p ? 'selected': ''}">
							<c:choose>
								<c:when test="${p <= pageInfo.totalPageCount }">
									<a href="${pageContext.servletContext.contextPath}/board/list?page=${p}&kwd=${pageInfo.kwd}">${p}</a>
								</c:when>
								<c:otherwise>
									${p}
								</c:otherwise>
							</c:choose>
							</li>
						</c:forEach>
					
						<li>
						<c:choose>
							<c:when test="${pageInfo.nextPage < pageInfo.totalPageCount}">
								<a href="${pageContext.servletContext.contextPath}/board/list?page=${pageInfo.nextPage}&kwd=${pageInfo.kwd}">▶</a>
							</c:when>
							<c:otherwise>
								▶
							</c:otherwise>
						</c:choose>
						</li>
					</ul>
				</div>					
				<!-- pager 추가 -->			
				
				<div class="bottom">
				
					<c:choose>
						<c:when test="${!empty authUser}">
							<a href="${pageContext.servletContext.contextPath}/board/write" id="new-book">글쓰기
							</a>
						</c:when>
						
						<c:otherwise>
							글을 쓰려면 로그인을 해주세요
						</c:otherwise>
					</c:choose>
		<form action="#" id="pageform">
			<input type="hidden" name="page" id="page" value="${pageInfo.page}" />
			<input type="hidden" name="kwd" id="kwd" value="${pageInfo.kwd}" />
		</form>
					
		<script type="text/javascript">
		
		$(document).ready(function(){
			var pageform = $("#pageform");
			
			$(".read").on("click",function(e){
				e.preventDefault();
				
				var no = $(this).attr("href");

				
				pageform.attr("action","${pageContext.servletContext.contextPath}/board/read/" + no).attr("method","get").submit();
			});
		});

		
		</script>
				
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
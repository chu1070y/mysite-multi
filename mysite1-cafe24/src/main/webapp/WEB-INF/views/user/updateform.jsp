<%@page import="com.cafe24.mysite.vo.UserVO"%>
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
<link href="${pageContext.servletContext.contextPath}/assets/css/user.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="user">

				<form id="join-form" name="joinForm" method="post" action="${pageContext.servletContext.contextPath}/user?a=update">
					<input type="hidden" name="a" value="join">
					<input type="hidden" name="no" value="${userVO.no }">
					
					<label class="block-label" for="name">이름</label>
					<input id="name" name="name" type="text" value="${userVO.name }">

					<label class="block-label" for="email">이메일</label>
					<input id="email" name="email" type="text" value="${userVO.email }">
					<input type="button" value="id 중복체크">
					
					<label class="block-label">패스워드</label>
					<input name="password" type="password" value="${userVO.password }">
					
					<fieldset>
						<legend>성별</legend>
						<label>여</label> <input type="radio" name="gender" value="female" checked=${'female' eq userVO.gender ? 'checked':''} >
						<label>남</label> <input type="radio" name="gender" value="male" checked=${'male' eq userVO.gender ? 'checked':''}>
					</fieldset>
					
					<input type="submit" value="수정허긔">
					
				</form>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp" />
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>
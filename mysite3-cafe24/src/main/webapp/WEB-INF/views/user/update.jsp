<%@page import="com.cafe24.mysite.vo.UserVO"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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

				<form id="join-form" name="joinForm" method="post" action="${pageContext.servletContext.contextPath}/user/updateUser">
					<sec:csrfInput />
					<input type="hidden" name="no" value="${authUser.no }">
					
					<label class="block-label" for="name">이름</label>
					<input id="name" name="name" type="text" value="${authUser.name }">

					<label class="block-label" for="email">이메일</label>
					<input id="email" name="email" type="hidden" value="${authUser.email }" readonly="readonly">
					${authUser.email }
					<input type="button" value="id 중복체크">
					
					<label class="block-label">패스워드</label>
					<input name="password" type="password" value="${authUser.password }">
					
					<fieldset>
						<legend>성별</legend>
						<label>여</label> <input type="radio" name="gender" value="female" checked=${'female' eq authUser.gender ? 'checked':''} >
						<label>남</label> <input type="radio" name="gender" value="male" checked=${'male' eq authUser.gender ? 'checked':''}>
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
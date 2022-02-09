<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="now" value="<%=new java.util.Date()%>" />
<c:set var="sysDate" scope="request">
	<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" />
</c:set>

<%
String path = request.getContextPath();
session.setAttribute("path", path);
  request.setCharacterEncoding("UTF-8");  
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맛집을 알려주는 사람들</title>

<link rel="stylesheet" href="${path}/include/top.css">

</head>

<body>

	<header>맛집을 소개해주세요!!</header>
	<nav>

		<c:if test="${fid!=null }">
			&emsp;&emsp;
			<img src="./img/icons8-edit.png">
			<a href=${path}/fboard.do>맛집 등록</a>
			&emsp;<img src="./img/icons8-search-30.png"><a href=${path}/fboard_list.do>맛집 조회</a>
		</c:if>
		
		<c:if test="${fid ==null}">
			&emsp;
			<img src="./img/icons8-login-30.png">
			<a href=${path}/login.do>로그인</a>

		</c:if>
		<c:if test="${fid != null}">
			&emsp;
			<img src="./img/icons8-logout-30.png">
			<a href="${path}/logout.do">로그아웃</a>
			&emsp;
			<img src="./img/icons8-user-30.png">
			<a href="${path}/fmember_edit.do?fid=${fid}">나의정보</a>

		</c:if>
		<c:if test="${fid == 'admin' }">
			&emsp;
			<img src="./img/icons8-users-30.png">
			<a href="${path}/membermana.do">회원목록보기</a>

		</c:if>

		&emsp;<img src="./img/icons8-for-you-30.png"> <a
			href=${path}/membership.do>회원가입</a> &emsp;<img
			src="./img/icons8-home-30.png"> <a href=${path}/index.jsp>홈으로</a>

	</nav>
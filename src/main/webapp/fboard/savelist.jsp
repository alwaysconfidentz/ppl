<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/include/top.jsp" charEncoding="utf-8" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<section>
	<br> <br>
	<div align="center">
		<table border=1>

			<tr>
				<th>회원번호</th>
				<th>글번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성자</th>
				<th>사진</th>
				<th>날짜</th>

			</tr>

			<c:forEach var="save" items="${li}">
				<tr>
					<td>${save.fcustno}</td>
					<td>${save.fsno}</td>
					<td>${save.ftitle}</td>
					<td>${save.fcontent}</td>
					<td>${save.fwriter}</td>
					<td><img src="./files/${save.fimg}" width="100" height="100" /></td>
					<td>${sysDate}</td>

				</tr>



			</c:forEach>

		</table>
	</div>
</section>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/include/top.jsp" charEncoding="utf-8" />
<!DOCTYPE html>
<html>
<style>
.ftable {
	text-align: center;
}
</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<section>
<div align="center">
		<br><br>
			<h3>
			1. 페이지 사이즈 :${pageSize} &emsp; 2. 페이지 list size :
			${pageListSize}&emsp; 3. 전체 레코드수 : ${tc }&emsp; 4. 전체 페이지수 :
			${totalPage}<br> 5. 현재 레코드 : ${startIdx}&emsp; 6. 현재 페이지수 :
			${nowPage }&emsp; 7. 하단 가로 시작 페이지 : ${startListPage}&emsp; 8. 하단 가로
			마지막 페이지 : ${endListPage}&emsp;<br>
		</h3>
		
		<table border="1" class="ftable" align="center" width="500"
			height="300">

			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성자</th>
				<th>사진</th>
				<th>날짜</th>
			</tr>

			<c:forEach var="food" items="${li}">
				<tr>
					<td><a href="./fboard_edit.do?fsno=${food.fsno}">${food.fsno}</a></td>
					<td>${food.ftitle}</td>
					<td>${food.fcontent}</td>
					<td>${food.fwriter}</td>
					<td><img src="./files/${food.fimg}" width="100" height="100" /></td>
					<td>${sysDate}</td>
				</tr>



			</c:forEach>

		</table>
			<br>
		 <a href="${path}/fboard_list.do?startIdx=1&ch1=${ch1}&ch2=${ch2}">처음으로</a>&emsp;
		<c:choose>
			<c:when test="${startIdx <= pageListSize}">
				이전10페이지 &emsp;
			</c:when>
			<c:otherwise>
				<a href="${path}fboard_list.do?startIdx=${(startListPage -2) * PageLisgeSize +1}&ch1=${ch1}&ch2=${ch2}">이전10페이지</a>
				&emsp;
			</c:otherwise>
		</c:choose>

		<c:forEach var="a" begin="${startListPage}" end="${endListPage }">
			<c:if test="${a <= totalPage }">
				[<a href="${path}/fboard_list.do?startIdx=${(a-1)*pageListSize+1}&ch1=${ch1}&ch2=${ch2}">${a}</a>]
			</c:if>
		</c:forEach>
		&emsp;
		<c:choose>
			<c:when test="${endListPage >= totalPage}">
				다음10페이지 &emsp;
			</c:when>
			<c:otherwise>
				<a href="${path}/fboard_list.do?startIdx=${endListPage * pageListSize +1}&ch1=${ch1}&ch2=${ch2}">다음10페이지</a>
				&emsp;
			</c:otherwise>
		</c:choose>

		<c:url value="/fboard_list.do" var="url">
			<c:param name="startIdx" value="${endPage}"></c:param>
			<c:param name="ch1" value="${ch1}"></c:param>
			<c:param name="ch2" value="${ch2}"></c:param>
		</c:url>
		<a href="${url }">마지막으로</a>&emsp;
		
		
		
		
		
		<form action="${path}/fboard_list.do">
			<select name="ch1">
				<option value="ftitle">제목</option>
				<option value="fwriter">작성자</option>
			</select> <input type="text" name="ch2"> <input type="submit"
				value="검색하기">
		</form>
</div>
</section>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/include/top.jsp" charEncoding="utf-8" />

<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script>
	function del(dele) {
		alert("삭제확인" + dele.name);
		var path = '${pageContext.request.contextPath}';
		var str = dele.name;
		var datastr = {
			fid : str
		}

		$.ajax({
			type : "GET",
			url : path + "/fmemberdel.do",
			data : datastr,
			success : function(data) {
				location.href = (path + "/membermana.do")
			}
		})
	}
</script>
<section>
	<div align="center">
		<br>
		<h2>회원목록보기</h2>
		<h4>${fid}</h4>
		<h3>
			1. 페이지 사이즈 :${pageSize} &emsp; 2. 페이지 list size :
			${pageListSize}&emsp; 3. 전체 레코드수 : ${tc }&emsp; 4. 전체 페이지수 :
			${totalPage}<br> 5. 현재 레코드 : ${startIdx}&emsp; 6. 현재 페이지수 :
			${nowPage }&emsp; 7. 하단 가로 시작 페이지 : ${startListPage}&emsp; 8. 하단 가로
			마지막 페이지 : ${endListPage}&emsp;<br>
		</h3>
		<table border=1 width=450>
			<tr height=40>
				<th>Rownum</th>
				<th>Rnum</th>
				<th>회원번호</th>
				<th>아이디</th>
				<th>암호</th>
				<th>이름</th>
				<th>성별</th>
				<th>삭제</th>

			</tr>
			<c:forEach items="${m1}" var="m1">
				<tr>
					<td>${m1.rownum}</td>
					<td>${m1.rnum}</td>
					<td>${m1.fcustno}</td>
					<td>${m1.fid}</td>
					<td>${m1.fpwd}</td>
					<td>${m1.fname}</td>
					<td>${m1.fjender}</td>
					<td><button name="${m1.fid}" onclick="del(this)">삭제</button></td>
				</tr>
			</c:forEach>


		</table>
		<br>
		 <a href="${path}/membermana.do?startIdx=1&ch1=${ch1}&ch2=${ch2}">처음으로</a>&emsp;
		<c:choose>
			<c:when test="${startIdx <= pageListSize}">
				이전10페이지 &emsp;
			</c:when>
			<c:otherwise>
				<a href="${path}/membermana.do?startIdx=${(startListPage -2) * PageLisgeSize +1}&ch1=${ch1}&ch2=${ch2}">이전10페이지</a>
				&emsp;
			</c:otherwise>
		</c:choose>

		<c:forEach var="a" begin="${startListPage}" end="${endListPage }">
			<c:if test="${a <= totalPage }">
				[<a href="${path}/membermana.do?startIdx=${(a-1)*pageListSize+1}&ch1=${ch1}&ch2=${ch2}">${a}</a>]
			</c:if>
		</c:forEach>
		&emsp;
		<c:choose>
			<c:when test="${endListPage >= totalPage}">
				다음10페이지 &emsp;
			</c:when>
			<c:otherwise>
				<a href="${path}/membermana.do?startIdx=${endListPage * pageListSize +1}&ch1=${ch1}&ch2=${ch2}">다음10페이지</a>
				&emsp;
			</c:otherwise>
		</c:choose>

		<c:url value="/membermana.do" var="url">
			<c:param name="startIdx" value="${endPage}"></c:param>
			<c:param name="ch1" value="${ch1}"></c:param>
			<c:param name="ch2" value="${ch2}"></c:param>
		</c:url>
		<a href="${url }">마지막으로</a>&emsp;
	</div>

	<div align="center">
		<form action="${path}/membermana.do">
			<select name="ch1">
				<option value="fid">아이디</option>
				<option value="fname">이름</option>
			</select> <input type="text" name="ch2" /> <input type="submit" value="검색하기" />
		</form>
	</div>
	<br> <br> <br>
</section>
<c:import url="/include/bottom.jsp" charEncoding="utf-8" />


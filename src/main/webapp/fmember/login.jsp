<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/include/top.jsp" charEncoding="utf-8" />



<section>
	<div align="center">
		<br> <br>
		<form action="./login1.do" method="post">
			<h2>로그인하기</h2>
			<table border=1 width=400>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="fid" id="fid"></td>
				</tr>
				<tr>
					<td>암호</td>
					<td><input type="password" name="fpwd" id="fpwd"></td>
				</tr>
				<tr>
					<td colspan=2 align="center"><input type=submit value="로그인"></td>
				</tr>
			</table>
		</form>

	</div>
</section>
<c:import url="/include/bottom.jsp" charEncoding="utf-8" />

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/include/top.jsp"   charEncoding="utf-8"   />  
<!DOCTYPE html>
<html>
<head>
<style>
h1{
	text-align:center;
}

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<section>
<br> <br>
<h1>${fid}님글작성을해주세요</h1>
<form action="./insert.do" method="post" enctype="multipart/form-data">
<table border="1" class="ta" align="center" width="300" height="300">
<tr> <td>제목:</td> <td><input type="text" name="ftitle"></td></tr>
<tr> <td>글내용:</td><td><input type="text" name="fcontent"></td></tr>
<tr><td>작성자:</td><td><input type="text" name="fwriter" value="${fid}"></td></tr>
<tr><td>파일: </td><td><input type="file" name="updateFile"></td></tr>
<tr><td>날짜:</td><td><input type="text" name="fbjoindate" id="fbjoindate"  value="${sysDate} "></td></tr>

<tr><td colspan="2" align="center"><input type="submit" value="저장하기"></td></tr>
</table>
</form>
</section>
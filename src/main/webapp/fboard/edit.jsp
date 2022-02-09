<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/include/top.jsp"   charEncoding="utf-8"   />  
<!DOCTYPE html>
<html>
<head>

<script src="http://code.jquery.com/jquery-1.10.2.js"></script>

<script>
function delBtn(del){
	alert("삭제확인"+ del.name);
	

	var path = '${pageContext.request.contextPath}';	
	alert("경로"+ path);
	var str1= del.name;
	var datastr = {
				fsno: str1
	}
	$.ajax({
		type : "GET",
		url : path +"/fdelete.do",
		data : datastr,
		success : function(data){
			location.href = (path + "/fboard_list.do")
		}
	})
	
		
		
}

function saveBtn(save){
	alert("저장");
	

	var path = '${pageContext.request.contextPath}';	
	alert("경로"+ path);
	var str1= save.name;
	var datastr = {
				fsno: str1,
				fcustno:'${fcustno}'
	}
	$.ajax({
		type : "GET",
		url : path +"/fsaveinsert.do",
		data : datastr,
		success : function(data){
			location.href = (path + "/savelist.do")
		}
	})
	
		
		
}





</script>
<style>
h1{
	text-align:center;
}

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<section>
<div align="center">
<form action="./fboard_update.do" method="post"  enctype="multipart/form-data">
<br><br>
<img src="./files/${m.fimg}" width="300" height="200" />
<table border="1" class="ta" align="center">
<tr><td>번호:</td><td>${m.fsno}</td></tr>
<tr> <td>제목:</td> <td> <input type="text" name="ftitle" id="ftitle" value="${m.ftitle }"></td></tr>
<tr><td>글내용:</td> <td><input type="text" name="fcontent" id="fcontent" value="${m.fcontent }"></td></tr>
<tr><td>작성자:</td><td><input type="text"  name="fwriter" value="${m.fwriter}" id="fwriter"></td></tr>
<tr><td>파일: </td><td><input type="file" name="updateFile" value="${m.updateFile}" id="updateFile"></td></tr>
<tr><td>날짜:</td><td><input type="text" name="fbjoindate" id="fbjoindate"  value="${sysDate}" id="fbjoindate"></td></tr>
<tr><td colspan="2" align="center"><input type="submit" value="수정하기">&emsp;</td></tr>

</table>
</form>

<c:if test="${fid != null }">
<button name="${m.fsno }" onclick="saveBtn(this)" >저장하기</button>
</c:if>


<c:if test="${fid == 'admin' }">
<button   name="${m.fsno}" onclick="delBtn(this)">관리자만삭제하기</button>
</c:if>
</div>
</section>
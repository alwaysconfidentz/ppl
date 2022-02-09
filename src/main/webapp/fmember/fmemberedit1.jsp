<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/include/top.jsp" charEncoding="utf-8" />
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script>
	function del1(dele1) {
		alert("삭제확인" + dele1.name);

		var path = '${pageContext.request.contextPath}';
		var str = dele1.name;
		var datastr = {
			fid : str
		}
		
		$.ajax({
			type : "GET",
			url : path + "/fmemberdel1.do",
			data : datastr,
			success : function(data) {
				location.href = (path + "/index.jsp")

			}
	
		})

	};
	function up1(up11) {
		
		var path = '${pageContext.request.contextPath}';
		
		
		var pwd = $("#fpwd").val();
		if(pwd == null || pwd == undefined || pwd == ''){
			alert("비밀번호를 확인하세요")
			return;
		}
	

		
		var setda = {
			fpwd : $("#fpwd").val(),
			fname : $("#fname").val(),
			fjender : $("#fjender").val(),
			fjoindate : $("#fjoindate").val()
		};
	
		console.log(setda);
		
		alert(setda);
	
	};


</script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<section>
		<br> <br>
		<div align="center">
			<h2>${fid}님</h2>

				<table border="1">
					<tr>
						<td>번호</td>
						<td>${m.fcustno}</td>
					</tr>

					<tr>
						<td>아이디</td>
						<td>${m.fid}</td>
					</tr>
					<tr>
						<td>암호</td>
						<td><input type="password" name="fpwd" id="fpwd"></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input type="text" name="fname" id="fname"
							value="${m.fname}"></td>
					</tr>
					<tr>
						<td>성별</td>
						<td><select name="fjender" id="fjender">
								<option value="m">남자</option>
								<option value="w">여자</option>
						</select></td>
					</tr>
					<tr>
						<td>가입날짜</td>
						<td><input type="text" name="fjoindate" id="fjoindate"
							value="${sysDate}"></td>

					</tr>

					<tr>
						<td colspan="2" align="center">
							<button name="${m.fid}" onclick="del1(this)">삭제하기</button>
						</td>

					</tr>
							
					<tr>
						<td colspan="2" align="center">
							<button onclick="up1('${m.fid}')">수정하기</button>
						</td>

					</tr>
					
					
				</table>
			
		</div>
	</section>
	<c:import url="/include/bottom.jsp" charEncoding="utf-8" />
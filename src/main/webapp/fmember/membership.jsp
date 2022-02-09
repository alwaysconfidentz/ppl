<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/include/top.jsp" charEncoding="utf-8" />
<!DOCTYPE html>
<html>
<head>

<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script>
	$(document).ready(function() {
		var idCheck = false;
		var path = '${pageContext.request.contextPath}';

		jQuery.ajaxSetup({
			cache : false
		});

		function isId(asValue) {
			var regExp = /^[a-z]+[a-z0-9]{5,19}$/g;
			return regExp.test(asValue);
		}

		// ajax를 통한 id 중복처리
		$("#ckBtn").click(function() {

			var id = $("#fid").val();
			if (id == null || id == undefined || id == '') {
				alert("사용할수 없는 아이디 입니다.")
				return;
			} else if (isId(id) == false) {
				alert("영어와 숫자를 합한 아이디를 사용해주세요.")
				return;
			}
			var dataStr = {
				fid : id
			// fid 는 vo 의값 id 는 스크립트에서 설정한 변수값 
			};

			console.log(path + "/memberck.do");
			$.ajax({
				type : "GET",
				url : path + "/memberck.do",
				data : dataStr,
				success : function(data) {

					console.log(data + "이게모냐")
					if (data == 100) {
						flag = 1;

						alert("사용가능한  ID 입니다.")
						idCheck = true;
						console.log(idCheck)
					} else {
						flag = 0;
						alert("사용 불가능한 ID 입니다.");
						$("#fid").value("");
						$("#fid").focus();
					}

				}
			})
		});

		$('#fid').keydown(function() {

			idCheck = false
		});

		$("#saveBtn").click(function() {

			console.log($("#fjender").val())

			var id = $("#fid").val();

			var pwd = $("#fpwd").val();
			
			var pwd2 = $("#fpwd2").val();
			
			
			if (id == null || id == undefined || id == '') {
				alert("사용할수 없는 아이디 입니다.")
				return;
			} else if (idCheck == false) {
				alert("id확인하세요")
				return;
			} else if (isId(id) == false) {
				alert("영어와 숫자를 합한 아이디를 사용해주세요.")
				return;
			}
			
			if(pwd != pwd2){
				alert("비밀번호를 재확인해주세요");
				$("#fpwd").val('');
				 $("#fpwd2").val('');
				 
				
				return;
			}
			
			var datad = {
				fid : $("#fid").val(),
				fpwd : $("#fpwd").val(),
				fname : $("#fname").val(),
				fjender : $("#fjender").val(),
				fjoindate : $("#fjoindate").val()
			};
			
			$.ajax({
				type : "POST",
				url : path + "/memberOk.do",
				data : datad,
				success : function(data){
					alert("회원가입을 축하드려요");
					console.log(data);
					location.href="/k1/index.html";
				}
			})

			

		})
	})

</script>


<meta charset="UTF-8">
<title>Insert title here</title>
</head>


<section>
	<br> <br>
	<div align="center">
		<h2>회원가입을 해주세요</h2>
		<form>
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="fid" id="fid"> <input
						type="button" id="ckBtn" value="id확인"></td>
				</tr>
				<tr>
					<td>암호</td>
					<td><input type="password" name="fpwd" id="fpwd"></td>
				</tr>
				
					<tr>
					<td>암호확인</td>
					<td><input type="password" name="fpwd" id="fpwd2"></td>
				</tr>
				
				<tr>
					<td>이름</td>
					<td><input type="text" name="fname" id="fname"></td>
				</tr>
				<tr>
					<td>성별</td>
					<td><select name="fjender" id="fjender">
							<option value="m">남자</option>
							<option value="w">여자</option>
					</select></td>
				</tr>

				<tr>
					<td>가입일자</td>
					<td><input type="text" name="fjoindate" id="fjoindate"
						value="${sysDate} "></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="button"
						id="saveBtn" value="저장하기"></td>
				</tr>
			</table>
		</form>
	</div>
</section>
<c:import url="/include/bottom.jsp" charEncoding="utf-8" />
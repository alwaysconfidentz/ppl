<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
 <c:import url="/include/top.jsp"   charEncoding="utf-8"   />   
     
	<section>
		<br>
		<div id=sectionDiv1>
			
		</div>
		<div id=sectionDiv2  align="center">
		<br><br>
		<c:if test="${fid != null }">
		<h3>${fid}(${fname})님 안녕하세요	</h3>
		${fname}
		</c:if>
		<br><br>	
		<img src="./img/sushi.png"  width=600  height=250 />
					
		</div>

	</section>

	<c:import url="/include/bottom.jsp"   charEncoding="utf-8"   />  
